package com.algo.F9;

/**
 * Created by timothy on 2017-02-14, com.algo.F9.
 */
public class SelectionSort {

    public static int[] sort(int[] ints) {
        int position = 0;
        int smallest;
        int tmp = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            smallest = Integer.MAX_VALUE;
            for (int j = i; j < ints.length; j++)
                if (ints[j] < smallest) {
                    position = j;
                    smallest = ints[j];
                }
            tmp = ints[i];
            ints[i] = ints[position];
            ints[position] = tmp;
        }
        return ints;
    }

}
