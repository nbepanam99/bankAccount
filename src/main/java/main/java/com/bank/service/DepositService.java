package main.java.com.bank.service;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.usecase.Deposit;

import java.math.BigDecimal;

public class DepositService implements Deposit {
    @Override
    public void deposit(BankAccount bankAccount, BigDecimal amount) {
        bankAccount.deposit(amount);
    }
}
