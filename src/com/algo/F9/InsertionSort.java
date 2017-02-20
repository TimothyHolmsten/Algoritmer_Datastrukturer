package com.algo.F9;

/**
 * Created by timothy on 2017-02-14, com.algo.F9.
 */
public class InsertionSort {
    public static int[] sort(int[] ints) {
        int now;
        int j = 0;
        for (int i = 1; i < ints.length; i++) {
            now = ints[i];
            j = i;
            while (j > 0 && now < ints[j - 1]) {
                ints[j] = ints[j - 1];
                j--;
            }
            ints[j] = now;
        }
        return ints;
    }
}
