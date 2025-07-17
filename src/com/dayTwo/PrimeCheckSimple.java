package com.dayTwo;
import java.util.Scanner;

public class PrimeCheckSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false; // 0 and 1 are not prime
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

    }
}

