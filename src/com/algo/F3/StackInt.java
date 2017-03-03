package com.algo.F3;

/**
 * Created by timothy on 2017-01-22, com.algo.F3.
 */
public interface StackInt<T> {
    T push(T obj);

    T peek();

    T pop();

    boolean empty();
}
