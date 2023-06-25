package com.amrita.jpl.cys21051.pract.simplecalc;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1, number2;
        double result;
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        String choice = sc.next();
        System.out.print("Enter the first number: ");
        number1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        number2 = sc.nextInt();
        double x;
        switch (choice) {
            case "1":
                x = number1 + number2;
                break;
            case "2":
                x = number1 - number2;
                break;
            case "3":
                x = number1 * number2;
                break;
            case "4":
                if (number2 == 0) {
                    System.out.println("Error: Division by zero is not allowed");
                    return;
                }
                x = (double) number1 / number2;
                break;
            default:
                System.out.println("Error: Invalid operation selected");
                return;
        }
        System.out.println("Result: " + x);
    }
}

