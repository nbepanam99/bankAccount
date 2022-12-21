package main.java.com.bank.service;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.exception.BankAccountException;
import main.java.com.bank.usecase.Withdraw;

import java.math.BigDecimal;

public class WithdrawalService implements Withdraw {

    @Override
    public void withdraw(BankAccount bankAccount, BigDecimal amount) throws BankAccountException {
        bankAccount.withdraw(amount);
    }


}
