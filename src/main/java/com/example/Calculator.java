package com.example;

import java.util.Stack;

public class Calculator {
    public static  String calculate(String expression) {
        try {
            // Remove white spaces from the expression
            expression = expression.replaceAll("\\s+", "");

            // Validate the expression for invalid characters
            if (!isValidExpression(expression)) {
                return "Invalid expression: contains invalid characters";
            }

            // Evaluate the expression
            double result = evaluateExpression(expression);

            // Check for division by zero
            if (Double.isInfinite(result) || Double.isNaN(result)) {
                return "Error: Division by zero";
            }

            // Convert the result to string and return
            return Double.toString(result);
        } catch (Exception e) {
            // Handle any other exceptions
            return "Error: " + e.getMessage(); // Return the error message
        }
    }

    private static boolean isValidExpression(String expression) {
        // Your validation logic goes here
        // For simplicity, assuming that the expression is valid if it contains only digits, operators, and parentheses
        return expression.matches("[\\d\\+\\-\\*\\/\\(\\)]+");
    }

    private static double evaluateExpression(String expression) {
        // Convert infix expression to postfix expression
        String postfix = infixToPostfix(expression);

        // Evaluate the postfix expression
        return evaluatePostfix(postfix);
    }

    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Discard the '('
            } else { // Operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0; // Default precedence for parentheses
    }

    private static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + c);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }
}
