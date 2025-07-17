package com.Assignment2;
import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 10000; // Initial balance
        int choice;

        while (true) {
            // Menu Display
            System.out.println("\n==Welcome To ATM System==");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Switch-case to perform operations
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("₹" + deposit + " deposited successfully.");
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("₹" + withdraw + " withdrawn successfully.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount!");
                    }
                    break;

                case 3:
                    System.out.println("Your current balance is: ₹" + balance);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    sc.close();
                    System.exit(0); // Exit the program

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
