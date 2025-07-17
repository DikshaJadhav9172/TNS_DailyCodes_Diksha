package com.dayTwo;
import java.util.Scanner;

public class BloodDonationEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input details
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your hemoglobin level : ");
        double hb = scanner.nextDouble();

        // Check eligibility
        if (age >= 18 && age <= 65) {
            if (weight >= 50) {
                if (hb >= 12.5) {
                    System.out.println("You are eligible to donate blood.");
                } else {
                    System.out.println("You are not eligible to donate blood due to low hemoglobin level.");
                }
            } else {
                System.out.println("You are not eligible to donate blood due to insufficient weight.");
            }
        } else {
            System.out.println("You are not eligible to donate blood due to age restrictions.");
        }

       
    }
}
