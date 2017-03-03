package com.algo.TEN1_160324.Uppg4;

import java.util.EmptyStackException;
import java.util.Stack;

public class InfixEvaluator {

    private static final String OPERATORS = "+-*/";
    private static final Stack<Integer> numbers = new Stack<>();
    private static final Stack<Character> operators = new Stack<>();

    private static boolean shouldCalculate(char ch) {
        boolean bool = false;
        switch (ch) {
            case '+':
                bool = true;
                break;
            case '-':
                bool = true;
                break;
            case '/':
                bool = !operators.empty();
                break;
            case '*':
                bool = !operators.empty();
                break;
        }
        return bool;
    }

    private static int calculate(char ch, int left, int right) {
        int value = 0;
        switch (ch) {
            case '+':
                value = left + right;
                break;
            case '-':
                value = left - right;
                break;
            case '/':
                value = left / right;
                break;
            case '*':
                value = left * right;
                break;
        }
        return value;
    }

    private static int calculate() {
        int value = 0;
        int right;
        int left;
        while (!operators.empty()) {
            if (!numbers.empty()) {
                right = numbers.pop();
                left = numbers.pop();
                value = numbers.push(calculate(operators.pop(), left, right));
            }
        }
        return value;
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {

        String[] tokens = expression.split(" +");
        int value = 0;
        boolean lastWasDigit = false;

        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {
                    int number = Integer.parseInt(nextToken);
                    numbers.push(number);
                    lastWasDigit = true;
                } else if (isOperator(nextToken.charAt(0))) {
                    if (!lastWasDigit)
                        throw new SyntaxErrorException("Invalid expression encountered");

                    if (shouldCalculate(nextToken.charAt(0)) && numbers.size() >= 2)
                        value = calculate();
                    operators.push(nextToken.charAt(0));

                    lastWasDigit = false;
                } else {
                    throw new SyntaxErrorException("Invalid expression encountered");
                }
            }
            if (!numbers.empty()) {
                System.out.println(numbers.size());
                value = calculate();
            }

        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
        return value;
    }

    public static class SyntaxErrorException extends Exception {

        SyntaxErrorException(String message) {
            super(message);
        }
    }
}