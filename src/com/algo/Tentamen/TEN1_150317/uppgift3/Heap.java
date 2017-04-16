package com.algo.Tentamen.TEN1_150317.uppgift3;

/**
 * Created by timothy on 2017-03-13, com.algo.Tentamen.TEN1_150317.uppgift3.
 */
public class Heap {

    private static final int[] array = new int[1000];
    private int size;

    public Heap() {
        size = 0;
    }

    // 4,12,19,24,30,41,91,82
    public boolean insert(int data) {
        if (size == 1000)
            return false;
        array[size] = data;
        int myPos = size;
        while (myPos != 0 && data < array[myParent(myPos)]) {
            array[myPos] = array[myParent(myPos)];
            array[myParent(myPos)] = data;
            myPos = myParent(myPos);
        }
        size++;
        return true;
    }

    private int myParent(int pos) {
        return (pos - 1) / 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++)
            sb.append(array[i] + ", ");
        return sb.toString();
    }
}
