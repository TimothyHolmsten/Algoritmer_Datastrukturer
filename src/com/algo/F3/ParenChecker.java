package com.algo.F3;

import java.util.Stack;

/**
 * Created by timothy on 2017-01-24, com.algo.F3.
 */
public class ParenChecker {
    private static final String OPEN = "([{";
    private static final String CLOSED = ")]}";

    private static boolean isOpen(char ch) {
        return OPEN.indexOf(ch) != -1;
    }

    private static boolean isClosed(char ch) {
        return CLOSED.indexOf(ch) != -1;
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> characterStack = new Stack<>();
        boolean balanced = true;
        int index = 0;
        char character;
        while (balanced && index < expression.length()) {
            character = expression.charAt(index);
            if (isOpen(character))
                characterStack.push(character);
            else if (isClosed(character)) {
                if (characterStack.isEmpty() || CLOSED.indexOf(characterStack.pop()) != OPEN.indexOf(character))
                    balanced = false;
            }
            index++;
        }

        return balanced && characterStack.isEmpty();
    }
}
