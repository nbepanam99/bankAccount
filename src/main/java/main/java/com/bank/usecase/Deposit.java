package main.java.com.bank.usecase;

import main.java.com.bank.domain.BankAccount;

import java.math.BigDecimal;

public interface Deposit {

    void deposit(BankAccount bankAccount, BigDecimal amount);


}
