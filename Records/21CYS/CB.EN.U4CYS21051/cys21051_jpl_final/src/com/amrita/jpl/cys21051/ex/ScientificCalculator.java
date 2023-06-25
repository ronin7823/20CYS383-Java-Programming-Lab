package com.amrita.jpl.cys21051.ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {

    private JTextField inputField;
    private String[] buttonLabels = {
            "7", "8", "9", "/", "sin",
            "4", "5", "6", "*", "cos",
            "1", "2", "3", "-", "tan",
            "0", ".", "=", "+", "mod",
            "C", "log"
    };

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5));

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("=")) {
            String expression = inputField.getText();
            double result = evaluateExpression(expression);
            inputField.setText(String.valueOf(result));
        } else if (action.equals("C")) {
            inputField.setText("");
        } else if (action.equals("sin") || action.equals("cos") || action.equals("tan") ||
                action.equals("mod") || action.equals("log")) {
            double value = Double.parseDouble(inputField.getText());
            double result = calculateFunction(action, value);
            inputField.setText(String.valueOf(result));
        } else {
            inputField.setText(inputField.getText() + action);
        }
    }

    private double evaluateExpression(String expression) {
        // Implement parsing and evaluation logic for arithmetic expressions
        // Return the evaluated result or 0 if there's an error
        return 0;
    }

    private double calculateFunction(String function, double value) {
        switch (function) {
            case "sin":
                return Math.sin(Math.toRadians(value));
            case "cos":
                return Math.cos(Math.toRadians(value));
            case "tan":
                return Math.tan(Math.toRadians(value));
            case "mod":
                // Extract two numbers from the input and calculate the remainder
                // Return the calculated result or an error message if there's an invalid input
                return 0;
            case "log":
                // Calculate the logarithm of the input using the appropriate base
                // Return the calculated result or an error message if there's an invalid input
                return 0;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
