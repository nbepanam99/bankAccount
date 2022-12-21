package main.java.com.bank.domain;

import main.java.com.bank.exception.BankAccountException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static main.java.com.bank.domain.EventType.DEPOSIT;
import static main.java.com.bank.domain.EventType.WITHDRAW;

public class BankAccount {

    private BigDecimal balance;
    private List<Operation> operations;

    public BankAccount() {
        operations = new ArrayList<>();
        this.balance = BigDecimal.ZERO;
    }


    public void deposit(BigDecimal amount) throws BankAccountException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BankAccountException("Unauthorized deposit operation: Operation amount must be greater than zero");
        }

        balance = balance.add(amount);
        this.operations.add(new Operation(DEPOSIT, amount, balance));

    }

    public void withdraw(BigDecimal amount) throws BankAccountException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BankAccountException("Unauthorized withdraw operation: Amount must be greater than 0");
        }

        if (this.balance.compareTo(amount) < 0) {
            throw new BankAccountException("Unauthorized withdraw operation: Insufficient funds, withdrawal cannot be done.");
        }

        balance = balance.subtract(amount);
        Operation operation = new Operation(WITHDRAW, amount, balance);
        this.operations.add(operation);

    }

    public List<Operation> getHistory() {
        return operations;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
