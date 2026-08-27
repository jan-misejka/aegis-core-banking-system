package cz.aegis.corebanking.service;

import cz.aegis.corebanking.dto.AccountResponse;
import cz.aegis.corebanking.dto.CreateAccountRequest;
import cz.aegis.corebanking.dto.DepositMoneyRequest;
import cz.aegis.corebanking.entity.Account;
import cz.aegis.corebanking.entity.Client;
import cz.aegis.corebanking.entity.Transaction;
import cz.aegis.corebanking.exception.AccountNotFoundException;
import cz.aegis.corebanking.exception.ClientNotFoundException;
import cz.aegis.corebanking.exception.InvalidAccountDataException;
import cz.aegis.corebanking.repository.AccountRepository;
import cz.aegis.corebanking.repository.ClientRepository;
import cz.aegis.corebanking.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountService {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(ClientRepository clientRepository,
                          AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public AccountResponse createAccount(CreateAccountRequest request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new ClientNotFoundException(request.getClientId()));

        //Validace hodnot:
        if (!request.getAccountType().equals("CURRENT")
                && !request.getAccountType().equals("SAVINGS")) {
            throw new InvalidAccountDataException("Invalid account type");
        }

        if (!request.getCurrency().equals("CZK")
                && !request.getCurrency().equals("EUR")
                && !request.getCurrency().equals("USD")) {
            throw new InvalidAccountDataException("Unsupported currency");
        }

        Account account = new Account();

        account.setClient(client);
        account.setAccountType(request.getAccountType());
        account.setCurrency(request.getCurrency());
        account.setBalance(BigDecimal.ZERO);
        account.setIban(generateIban());

        Account savedAccount = accountRepository.save(account);

        AccountResponse response = new AccountResponse();

        response.setAccountId(savedAccount.getAccountId());
        response.setClientId(savedAccount.getClient().getClientId());
        response.setIban(savedAccount.getIban());
        response.setAccountType(savedAccount.getAccountType());
        response.setBalance(savedAccount.getBalance());
        response.setCurrency(savedAccount.getCurrency());
        response.setCreatedAt(savedAccount.getCreatedAt());

        return response;
    }

    @Transactional
    public AccountResponse depositMoney(Long accountId, DepositMoneyRequest request) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(accountId));

        account.setBalance(account.getBalance().add(request.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setTransactionType("DEPOSIT");
        transaction.setAmount(request.getAmount());
        transaction.setCreatedAt(LocalDateTime.now());

        accountRepository.save(account);
        transactionRepository.save(transaction);

        AccountResponse response = new AccountResponse();

        response.setAccountId(account.getAccountId());
        response.setClientId(account.getClient().getClientId());
        response.setIban(account.getIban());
        response.setAccountType(account.getAccountType());
        response.setBalance(account.getBalance());
        response.setCurrency(account.getCurrency());
        response.setCreatedAt(account.getCreatedAt());

        return response;
    }

    //BBAN generator metoda
    private String generateIban() {

        while (true) {

            long accountNumber = ThreadLocalRandom.current().nextLong(0, 10_000_000_000L);

            String accountNumberFormatted = String.format("%010d", accountNumber);

            String bankCode = "0800";
            String prefix = "000000";

            String bban = bankCode + prefix + accountNumberFormatted;
            String checkString = bban + "123500";

            BigInteger number = new BigInteger(checkString);

            int remainder = number.mod(BigInteger.valueOf(97)).intValue();

            int checkDigits = 98 - remainder;

            String ibanCheckDigits = String.format("%02d", checkDigits);

            String iban = "CZ" + ibanCheckDigits + bban;

            if (!accountRepository.existsByIban(iban)) {
                return iban;
            }
        }
    }
}