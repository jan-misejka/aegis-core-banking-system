package cz.aegis.corebanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Void> handleClientNotFound(ClientNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Void> handleAccountNotFound(AccountNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Void> handleInsufficientBalance(InsufficientBalanceException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(SameAccountTransferException.class)
    public ResponseEntity<Void> handleSameAccountTransfer(SameAccountTransferException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> handleValidationException(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(InvalidAccountDataException.class)
    public ResponseEntity<Void> handleInvalidAccountData(InvalidAccountDataException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}