package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

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
    @DisplayName("Withdraw will become negative, not 0")
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


    @Test
    @DisplayName("Test the holder name is not empty")
    public void TestHolderName() {
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Fredie");
        assertNotNull(bankAccount.getHolderName());

    }

    @Test
    @DisplayName("Test we cannot withdraw below minimum")
    public void testNoWithdrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(5000));
    }


    @Test
    @DisplayName("Test there are no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithoutExceptions(){
    BankAccount bankAccount = new BankAccount(500, -1000);
    // -> lambda expression, check details and examples at https://www.w3schools.com/java/java_lambda.asp
    assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(300));
    }


    @Test
    @DisplayName("Test if the deposit will take more than 1 second")
    public void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(600, 0);
        // the fail() method works similar to xfail in pytest
        // fail();
        assertTimeout(Duration.ofSeconds(1), () -> bankAccount.deposit(200));
    }

}
