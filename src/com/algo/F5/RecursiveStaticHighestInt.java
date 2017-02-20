package com.algo.F5;

import java.util.ArrayList;

/**
 * Created by timothy on 2017-01-30, com.algo.F5.
 */
public class RecursiveStaticHighestInt {

    public RecursiveStaticHighestInt() {
    }

    public static int calculate(ArrayList<Integer> arrayList, int highest) {
        if (arrayList.size() > 0) {
            int i = arrayList.remove(0);
            if (i > highest)
                return calculate(arrayList, i);
            return calculate(arrayList, highest);
        }
        return highest;
    }
}