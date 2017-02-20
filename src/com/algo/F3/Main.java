package com.algo.F3;

/**
 * Created by timothy on 2017-01-22, com.algo.F3.
 */

public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.push(4));
        System.out.println(stack.peek());
        System.out.println(stack.push(1337));

        String expression = "(5+5)";
        System.out.println(ParenChecker.isBalanced(expression));

        ArrayListStack<String> stringArrayListStack = new ArrayListStack<>();
        stringArrayListStack.push("Timothy");
        stringArrayListStack.push("Nicholas");
        stringArrayListStack.push("Chatarina");
        System.out.println(stringArrayListStack);
        System.out.println(stringArrayListStack.pop());
        System.out.println(stringArrayListStack);
    }
}

