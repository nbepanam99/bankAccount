package main.java.com.bank.usecase;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.exception.BankAccountException;

import java.math.BigDecimal;

public interface Withdraw {

    void withdraw(BankAccount bankAccount, BigDecimal amount) throws BankAccountException;

}
