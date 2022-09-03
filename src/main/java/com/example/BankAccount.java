package com.example;

public class BankAccount {
    private double balance;
    private double minimumBalance;

    private boolean isActive = true;

    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public double withdraw(double amount) {
        if (balance - amount > minimumBalance) {
            balance = balance - amount;
            return amount;
        }
        else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount) {
        return balance = balance + amount;
    }

    public boolean isActive() {
        return isActive;
    }
}

