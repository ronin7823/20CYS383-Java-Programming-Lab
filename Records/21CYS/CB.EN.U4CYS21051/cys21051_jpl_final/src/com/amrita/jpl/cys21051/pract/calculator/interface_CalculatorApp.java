package com.amrita.jpl.cys21051.pract.calculator;

import java.util.Scanner;

interface Calculator {
    double calculate(double num1, double num2);
}

class Addition implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

class Subtraction implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

class Division implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Cannot divide by zero!");
        }
    }
}

public class interface_CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter number 2: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int choice = scanner.nextInt();

        Calculator calculator;

        switch (choice) {
            case 1:
                calculator = new Addition();
                break;
            case 2:
                calculator = new Subtraction();
                break;
            case 3:
                calculator = new Multiplication();
                break;
            case 4:
                calculator = new Division();
                break;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        double result = calculator.calculate(num1, num2);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
