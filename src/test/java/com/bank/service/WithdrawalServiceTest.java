package com.bank.service;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.service.DepositService;
import main.java.com.bank.service.WithdrawalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("A Withdraw test case")
public class WithdrawalServiceTest {

    private final WithdrawalService withdrawalService = new WithdrawalService();
    private final DepositService depositService = new DepositService();

    @Test
    @DisplayName("Withdraw amount from account")
    public void shouldAddAmount() {
        // Given
        BankAccount initialBankAccount = new BankAccount();

        // When
        depositService.deposit(initialBankAccount,BigDecimal.valueOf(100));
        withdrawalService.withdraw(initialBankAccount, BigDecimal.valueOf(50));

        // Then
        assertEquals(initialBankAccount.getBalance(), BigDecimal.valueOf(50));

    }

    @Test
    @DisplayName("Throw exception for negative amount")
    public void shouldThrowException() {
        // Given
        BankAccount initialBankAccount = new BankAccount();

        // When
        Exception exception = assertThrows(Exception.class,
                () -> withdrawalService.withdraw(initialBankAccount, BigDecimal.valueOf(-100))
        );

        // Then
        assertEquals("Unauthorized withdraw operation: Amount must be greater than 0", exception.getMessage());

    }

    @Test
    @DisplayName("Throw exception because Insufficient funds")
    public void shouldThrowExceptionInsufficientFunds() {
        // Given
        BankAccount initialBankAccount = new BankAccount();

        // When
        Exception exception = assertThrows(Exception.class,
                () -> withdrawalService.withdraw(initialBankAccount, BigDecimal.valueOf(100))
        );

        // Then
        assertEquals("Unauthorized withdraw operation: Insufficient funds, withdrawal cannot be done.", exception.getMessage());

    }

}
