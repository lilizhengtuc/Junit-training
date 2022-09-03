package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount Class")
public class BankAccountTest {

    @Test
    @DisplayName("Withdraw 500 successfully!")
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 300 successfully!")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(800, 200);
        bankAccount.deposit(300);
        assertEquals(1100, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void withdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(300, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test the bank account is active after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(400, 100);
        assertTrue(bankAccount.isActive());
    }
}
