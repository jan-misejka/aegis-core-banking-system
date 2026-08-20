package cz.aegis.corebanking.service;

import cz.aegis.corebanking.dto.AccountResponse;
import cz.aegis.corebanking.dto.CreateAccountRequest;
import cz.aegis.corebanking.entity.Account;
import cz.aegis.corebanking.entity.Client;
import cz.aegis.corebanking.exception.ClientNotFoundException;
import cz.aegis.corebanking.exception.InvalidAccountDataException;
import cz.aegis.corebanking.repository.AccountRepository;
import cz.aegis.corebanking.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountService {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;

    public AccountService(ClientRepository clientRepository, AccountRepository accountRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
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