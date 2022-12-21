package com.bank.service;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.domain.Operation;
import main.java.com.bank.service.DepositService;
import main.java.com.bank.service.HistoryService;
import main.java.com.bank.service.WithdrawalService;
import main.java.com.bank.usecase.History;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Operation list Service")
public class HistoryServiceTest {

    private final History historyService = new HistoryService();
    private final BankAccount bankAccount = new BankAccount();
    private final DepositService depositService = new DepositService();
    private final WithdrawalService withdrawalService = new WithdrawalService();

    @BeforeEach
    void setUp() {
        depositService.deposit(bankAccount, BigDecimal.valueOf(464));
        withdrawalService.withdraw(bankAccount, BigDecimal.valueOf(40));
        withdrawalService.withdraw(bankAccount, BigDecimal.valueOf(60));
        depositService.deposit(bankAccount, BigDecimal.valueOf(630));
    }


    @Test
    @DisplayName("Return 4 operations")
    public void shouldReturnListOfOperation() {
        List<Operation> history = historyService.getHistory(bankAccount);
        assertEquals(history.size(), 4);
    }


}
