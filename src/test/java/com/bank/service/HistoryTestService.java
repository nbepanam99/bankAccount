package com.bank.service;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.domain.Operation;
import main.java.com.bank.service.DepositService;
import main.java.com.bank.service.HistoryService;
import main.java.com.bank.service.WithdrawalService;
import main.java.com.bank.usecase.History;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class HistoryTestService {

    History historyService = new HistoryService();
    BankAccount bankAccount = new BankAccount();

    DepositService depositService = new DepositService();
    WithdrawalService withdrawalService = new WithdrawalService();

    @BeforeEach
    void setUp() {
        depositService.deposit(bankAccount, BigDecimal.valueOf(464));
        withdrawalService.withdraw(bankAccount, BigDecimal.valueOf(40));
        withdrawalService.withdraw(bankAccount, BigDecimal.valueOf(60));
        depositService.deposit(bankAccount, BigDecimal.valueOf(630));
    }


    @Test
    public void shouldReturnListOfOperation() {

        List<Operation> history = historyService.getHistory(bankAccount);
        history.stream().forEach(System.out::println);

    }


}
