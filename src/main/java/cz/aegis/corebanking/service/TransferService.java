package cz.aegis.corebanking.service;

import cz.aegis.corebanking.dto.TransferMoneyRequest;
import cz.aegis.corebanking.dto.TransferResponse;
import cz.aegis.corebanking.entity.Account;
import cz.aegis.corebanking.entity.Transaction;
import cz.aegis.corebanking.entity.Transfer;
import cz.aegis.corebanking.exception.AccountNotFoundException;
import cz.aegis.corebanking.exception.InsufficientBalanceException;
import cz.aegis.corebanking.exception.SameAccountTransferException;
import cz.aegis.corebanking.repository.AccountRepository;
import cz.aegis.corebanking.repository.TransactionRepository;
import cz.aegis.corebanking.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final TransferRepository transferRepository;

    //Kontruktor

    public TransferService(AccountRepository accountRepository,
                           TransactionRepository transactionRepository,
                           TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.transferRepository = transferRepository;
    }

    //Metoda pro transfer
    @Transactional
    public TransferResponse transferMoney(TransferMoneyRequest request) {

        Account sourceAccount = accountRepository.findById(request.getSourceAccountId())
                .orElseThrow(() -> new AccountNotFoundException(request.getSourceAccountId()));

        Account targetAccount = accountRepository.findById(request.getTargetAccountId())
                .orElseThrow(() -> new AccountNotFoundException(request.getTargetAccountId()));

        if (sourceAccount.getAccountId().equals(targetAccount.getAccountId())) {
            throw new SameAccountTransferException();
        }

        if (sourceAccount.getBalance().compareTo(request.getAmount()) < 0) {
            throw new InsufficientBalanceException(request.getAmount(), sourceAccount.getBalance());
        }


        Transfer transfer = new Transfer();

        transfer.setSourceAccount(sourceAccount);
        transfer.setTargetAccount(targetAccount);
        transfer.setAmount(request.getAmount());
        transfer.setTransferStatus("COMPLETED");

        Transfer savedTransfer = transferRepository.save(transfer);

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(request.getAmount()));
        targetAccount.setBalance(targetAccount.getBalance().add(request.getAmount()));

        Transaction outboundTransaction = new Transaction();

        outboundTransaction.setAccount(sourceAccount);
        outboundTransaction.setTransfer(savedTransfer);
        outboundTransaction.setTransactionType("OUTBOUND");
        outboundTransaction.setAmount(request.getAmount());
        outboundTransaction.setCreatedAt(java.time.LocalDateTime.now());

        Transaction inboundTransaction = new Transaction();

        inboundTransaction.setAccount(targetAccount);
        inboundTransaction.setTransfer(savedTransfer);
        inboundTransaction.setTransactionType("INBOUND");
        inboundTransaction.setAmount(request.getAmount());
        inboundTransaction.setCreatedAt(java.time.LocalDateTime.now());

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        transactionRepository.save(outboundTransaction);
        transactionRepository.save(inboundTransaction);

        TransferResponse response = new TransferResponse();

        response.setTransferId(savedTransfer.getTransferId());
        response.setSourceAccountId(savedTransfer.getSourceAccount().getAccountId());
        response.setTargetAccountId(savedTransfer.getTargetAccount().getAccountId());
        response.setAmount(savedTransfer.getAmount());
        response.setTransferStatus(savedTransfer.getTransferStatus());
        response.setCreatedAt(savedTransfer.getCreatedAt());

        return response;
    }
}