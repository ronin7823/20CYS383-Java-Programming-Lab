package com.amrita.jpl.cys21051.pract.decimalconverter;

import java.util.Scanner;

public class DecimalToBinaryHexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid decimal number.");
            System.out.print("Enter a decimal number: ");
            scanner.next();
        }
        int decimalNumber = scanner.nextInt();

        while (decimalNumber < 0) {
            System.out.println("Decimal number cannot be negative. Please enter a non-negative decimal number.");
            System.out.print("Enter a decimal number: ");
            decimalNumber = scanner.nextInt();
        }

        String binaryNumber = Integer.toBinaryString(decimalNumber);
        String hexadecimalNumber = Integer.toHexString(decimalNumber);

        System.out.println("Binary representation: " + binaryNumber);
        System.out.println("Hexadecimal representation: " + hexadecimalNumber);

        scanner.close();
    }
}
