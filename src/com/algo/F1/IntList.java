package com.algo.F1;

import java.util.Arrays;

/**
 * Created by timothy on 2017-01-17, com.algo.F1.
 */
public class IntList {

    private int[] list;
    private int nrOfElements;

    public IntList(int initialCapacity) {
        list = new int[initialCapacity];
        nrOfElements = 0;
    }

    public void add(int element) {
        if (nrOfElements + 1 == list.length)
            reallocate();

        if (nrOfElements + 1 < list.length)
            list[nrOfElements++] = element;
    }

    public void add(int index, int element) {
        if (nrOfElements + 1 == list.length)
            reallocate();

        if (nrOfElements + 1 < list.length) {
            for (int i = nrOfElements; i > index; i--)
                list[i] = list[i - 1];
            list[index] = element;
            nrOfElements++;
        }
    }

    public int get(int index) {
        return list[index];
    }

    public int remove(int index) {
        int k = list[index];
        for (int i = index; i < nrOfElements; i++)
            list[i] = list[i + 1];
        nrOfElements--;
        return k;
    }

    public int[] getList() {
        int[] tmpList = new int[nrOfElements];
        for (int i = 0; i < nrOfElements; i++)
            tmpList[i] = list[i];
        return tmpList;
    }

    public int size() {
        return nrOfElements;
    }

    public void set(int index, int element) {
        if (nrOfElements + 1 == list.length)
            reallocate();
        if (index < nrOfElements) {
            list[index] = element;
            nrOfElements++;
        } else
            list[nrOfElements++] = element;
    }

    public int indexOf(int element) {
        for (int i = 0; i < nrOfElements; i++)
            if (list[i] == element)
                return i;
        return -1;
    }

    private void reallocate() {
        list = Arrays.copyOf(list, list.length * 2);
    }
}
