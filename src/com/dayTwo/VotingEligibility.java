package com.dayTwo;
import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take age input
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Check eligibility for voting 
        
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

    }
}
