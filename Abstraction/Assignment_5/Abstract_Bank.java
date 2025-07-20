package com.Assignment_5;

abstract class Account {
    protected String accountHolder;
    protected double balance;

    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract double getBalance();

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + getBalance());
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance in Savings Account.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class CheckingAccount extends Account {
    public CheckingAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class Abstract_Bank {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("Diksha", 10000);
        sa.deposit(2000);
        sa.withdraw(1500);
        sa.displayAccountInfo();

        CheckingAccount ca = new CheckingAccount("Ram", 5000);
        ca.deposit(1000);
        ca.withdraw(6000);
        ca.displayAccountInfo();
    }
}
