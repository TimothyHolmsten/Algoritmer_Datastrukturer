package com.algo.F3;

import java.util.ArrayList;

/**
 * Created by timothy on 2017-01-24, com.algo.F3.
 */
public class ArrayListStack<E> implements StackInt<E> {
    private ArrayList<E> list;

    public ArrayListStack() {
        list = new ArrayList<>();
    }

    @Override
    public E push(E obj) {
        list.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public E pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }
}
