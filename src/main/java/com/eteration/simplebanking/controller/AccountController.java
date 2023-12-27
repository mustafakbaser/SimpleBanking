package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.exception.AccountAlreadyExistsException;
import com.eteration.simplebanking.exception.AccountNotFoundException;
import com.eteration.simplebanking.exception.InsufficientBalanceException;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService1) {
        this.accountService = accountService1;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account account = accountService.findAccount(accountNumber);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(
            @PathVariable String accountNumber,
            @RequestBody DepositTransaction depositTransaction) throws AccountNotFoundException, InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        if (depositTransaction == null || depositTransaction.getAmount() <= 0) {
            return new ResponseEntity<TransactionStatus>(HttpStatus.BAD_REQUEST);
        }
        account.post(depositTransaction);
        TransactionStatus status = new TransactionStatus("OK",
                java.util.UUID.randomUUID().toString());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> insertAccount(@RequestBody Account account)
            throws AccountNotFoundException, AccountAlreadyExistsException {
        Account acc = accountService.createAccount(account);
        if (acc == null) {
            return new ResponseEntity<Account>(acc, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Account>(acc, HttpStatus.OK);
        }
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(
            @PathVariable String accountNumber,
            @RequestBody WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        account.post(withdrawalTransaction);
        TransactionStatus status = new TransactionStatus("OK", java.util.UUID.randomUUID().toString());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}