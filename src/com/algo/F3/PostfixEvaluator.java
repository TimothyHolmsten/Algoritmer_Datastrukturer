package com.algo.F3;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by timothy on 2017-01-22, com.algo.F3.
 */
public class PostfixEvaluator {

    private static final String OPERATORS = "+-*/";

    private Stack<Integer> operandStack;

    public PostfixEvaluator() {
        operandStack = new Stack<>();
    }

    private int evalOp(char op) {
        if (op == '+')
            return 1;
        else if (op == '-')
            return 2;
        else if (op == '*')
            return 3;
        else if (op == '/')
            return 4;
        return -1;
    }

    // Loops OPERATORS and tries to find the char
    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {
        String[] tokens = expression.split(" +");
        int sum = 0;
        try {
            for (String nextToken : tokens)
                if (Character.isDigit(nextToken.charAt(0))) {
                    operandStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    int right = operandStack.pop();
                    int left = operandStack.pop();
                    switch (evalOp(nextToken.charAt(0))) {
                        case 1:
                            sum += left + right;
                            break;
                        case 2:
                            sum += left - right;
                            break;
                        case 3:
                            sum += left * right;
                            break;
                        case 4:
                            sum += left / right;
                            break;
                    }
                } else
                    throw new SyntaxErrorException("Invalid character encountered");
        } catch (EmptyStackException e) {
            throw new SyntaxErrorException("The stack is empty");
        }
        return sum;
    }

    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }

        SyntaxErrorException() {
            super();
        }
    }
}
