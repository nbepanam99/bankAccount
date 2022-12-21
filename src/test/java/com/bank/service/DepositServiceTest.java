package com.bank.service;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.service.DepositService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("A Deposit test case")
public class DepositServiceTest {

    private final DepositService depositService = new DepositService();

    @Test
    @DisplayName("Add amount to account")
    public void shouldAddAmount() {
        // Given
        BankAccount initialBankAccount = new BankAccount();

        // When
        depositService.deposit(initialBankAccount, BigDecimal.valueOf(100));

        // Then
        assertEquals(initialBankAccount.getBalance(), BigDecimal.valueOf(100));

    }

    @Test
    @DisplayName("Throw exception for negative amount")
    public void shouldThrowException() {
        // Given
        BankAccount initialBankAccount = new BankAccount();

        // When
        Exception exception = assertThrows(Exception.class,
                () -> depositService.deposit(initialBankAccount, BigDecimal.valueOf(-100))
        );

        // Then
        assertEquals("Unauthorized deposit operation: Operation amount must be greater than zero", exception.getMessage());

    }

}
