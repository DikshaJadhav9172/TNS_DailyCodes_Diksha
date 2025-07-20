package com.Assignment_5;
class Transaction {
    private final double transactionFee = 10.0;

    public final void performTransaction(String type, double amount, double balance) {
        System.out.println("\nTransaction Type: " + type);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Transaction Fee: ₹" + transactionFee);

        double newBalance;

        if (type.equalsIgnoreCase("deposit")) {
            newBalance = balance + amount - transactionFee;
        } else if (type.equalsIgnoreCase("withdraw")) {
            if (amount + transactionFee <= balance) {
                newBalance = balance - amount - transactionFee;
            } else {
                System.out.println("Insufficient balance");
                return;
            }
        } else {
            System.out.println("Invalid transaction type");
            return;
        }

        System.out.println("Balance after Transaction: ₹" + newBalance);
    }

    public double getTransactionFee() {
        return transactionFee;
    }
}

public class Final_BankAccount {
    public static void main(String[] args) {
        Transaction txn = new Transaction();

        double balance1 = 5000;
        txn.performTransaction("deposit", 1000, balance1);

        double balance2 = 4900;
        txn.performTransaction("withdraw", 1500, balance2);
    }
}
