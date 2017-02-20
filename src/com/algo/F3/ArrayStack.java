package com.algo.F3;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by timothy on 2017-01-22, com.algo.F3.
 */
public class ArrayStack<E> implements StackInt<E> {
    private E[] data;
    private int top;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        data = ((E[]) new Object[maxSize]);
    }

    @Override
    public E push(E obj) {
        if (top == maxSize - 1)
            reallocate();

        data[++top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if (empty())
            throw new EmptyStackException();
        return data[top];
    }

    @Override
    public E pop() {
        if (empty())
            throw new EmptyStackException();
        return data[top--];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize * 2);
    }
}
