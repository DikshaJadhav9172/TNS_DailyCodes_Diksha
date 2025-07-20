package com.Assignment_5;
public class Bank {
    
    private static int totalAccounts = 0;
    private String accountHolderName;
    private double balance;

    public Bank(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        Bank acc1 = new Bank("Diksha", 10000);
        Bank acc2 = new Bank("Nikhil", 15000);
        Bank acc3 = new Bank("Deepal", 20000);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
        acc3.displayAccountDetails();

        System.out.println("Total Bank Accounts: " + Bank.getTotalAccounts());
    }
}
