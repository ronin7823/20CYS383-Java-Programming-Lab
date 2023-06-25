package com.amrita.jpl.cys21051.pract.factorial;

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.print("Enter a non-negative number: ");
            number = scanner.nextInt();

            if (number < 0) {
                System.out.println("Invalid input. The number must be non-negative.");
            }
        } while (number < 0);

        int factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        System.out.println("The factorial of " + number + " is: " + factorial);

        scanner.close();
    }
}



