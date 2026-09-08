package cz.aegis.corebanking.service;

import cz.aegis.corebanking.dto.CreateTransactionRequest;
import cz.aegis.corebanking.dto.TransactionResponse;
import cz.aegis.corebanking.entity.Account;
import cz.aegis.corebanking.entity.Transaction;
import cz.aegis.corebanking.exception.AccountNotFoundException;
import cz.aegis.corebanking.exception.InsufficientBalanceException;
import cz.aegis.corebanking.exception.InvalidTransactionTypeException;
import cz.aegis.corebanking.repository.AccountRepository;
import cz.aegis.corebanking.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public TransactionResponse createTransaction(CreateTransactionRequest request) {

        Account account = accountRepository.findById(request.getAccountId()).orElseThrow(() -> new AccountNotFoundException(request.getAccountId()));

        if ("DEPOSIT".equals(request.getType())) {
            account.setBalance(account.getBalance().add(request.getAmount()));

        } else if ("WITHDRAWAL".equals(request.getType())) {

            if (account.getBalance().compareTo(request.getAmount()) < 0) {
                throw new InsufficientBalanceException(
                        request.getAmount(),
                        account.getBalance()
                );
            }

            account.setBalance(account.getBalance().subtract(request.getAmount()));

        } else {
            throw new InvalidTransactionTypeException(request.getType());
        }

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setTransactionType(request.getType());
        transaction.setAmount(request.getAmount());

        accountRepository.save(account);

        Transaction savedTransaction = transactionRepository.save(transaction);

        TransactionResponse response = new TransactionResponse();

        response.setTransactionId(savedTransaction.getTransactionId());
        response.setAccountId(savedTransaction.getAccount().getAccountId());
        response.setTransactionType(savedTransaction.getTransactionType());
        response.setAmount(savedTransaction.getAmount());
        response.setCreatedAt(savedTransaction.getCreatedAt());

        return response;
    }
}