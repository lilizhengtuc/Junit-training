package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionTest {

    @Test
    @DisplayName("Test the bank account exists")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(400, 100);
        // assumeTrue(bankAccount != null);

        // The test will not run, because the precondition is not met
        // assumeTrue(bankAccount == null);

        // A message can be used to show the details of test aborted
        // assumeTrue(bankAccount == null, "Account is null");

        //assumeFalse negates the assumption
        assumeFalse(bankAccount == null, "Account is null");
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test the bank account exists")
    public void testActivewithAssumingThat() {
        BankAccount bankAccount = new BankAccount(400, 100);
        // assuming that takes an assumption, and an executable
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
    }
}