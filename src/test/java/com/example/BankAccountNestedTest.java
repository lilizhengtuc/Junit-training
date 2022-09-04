package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountNestedTest {

    @Test
    @DisplayName("Test withdraw 300")
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test deposit 500")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }

    // @Nested annotation will run the tests within the class WhenBalanceEqualsZero. Otherwise, only the 2 tests above will run
    @Nested
    class WhenBalanceEqualsZero {

        @Test
        @DisplayName("Throw an exception if withdraw is higher than minimum balance")
        public void testWithdrawMinimumBalanceIs0() {
            BankAccount bankAccount = new BankAccount(0, 0);
            // bankAccount.withdraw(500);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500) );
        }

        @Test
        @DisplayName("Withdraw and get a negative balance")
        public void testWithdrawMinimumBalanceNegative1000() {
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());
        }

    }

}
