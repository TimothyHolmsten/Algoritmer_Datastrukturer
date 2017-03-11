package com.algo.F9;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by timothy on 2017-03-11, com.algo.F9.
 */
public class RadixSort {
    /*
    Not the prettiest radix sort but whateva...
    May not even be a radix sort.
     */
    public static int[] sort(int[] array) {
        ArrayList<Integer>[] arrayLists = (ArrayList<Integer>[]) new ArrayList<?>[array.length];
        for (int i = 0; i < array.length; i++)
            arrayLists[i] = new ArrayList<>();

        boolean allZero = false;
        int m = 10;
        int n = 1;
        while (!allZero) {
            for (int i : array)
                arrayLists[(i % m) / n].add(i);

            if (arrayLists[0].size() == array.length)
                allZero = true;

            int pos = 0;
            for (int i = 0; i < array.length; i++) {
                for (int integer : arrayLists[i])
                    array[pos++] = integer;
                arrayLists[i].clear();
            }
            HashMap h = new HashMap();
            m = m * 10;
            n = n * 10;
        }
        return array;
    }
}
