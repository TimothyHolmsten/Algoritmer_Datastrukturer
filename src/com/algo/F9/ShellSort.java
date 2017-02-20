package com.algo.F9;

/**
 * Created by timothy on 2017-02-17, com.algo.F9.
 */
public class ShellSort {
    public static int[] sort(int[] ints) {
        int gap = ints.length / 2;
        while (gap > 0) {
            for (int nextPos = gap; nextPos < ints.length; nextPos++)
                insert(ints, nextPos, gap);
            if (gap == 2)
                gap = 1;
            else
                gap = (int) (gap / 2.2);
        }
        return ints;
    }

    private static void insert(int[] ints, int nextPos, int gap) {
        int nextVal = ints[nextPos];

        while (nextPos > gap - 1 && new Integer(nextVal).compareTo(ints[nextPos - gap]) < 0) {

            ints[nextPos] = ints[nextPos - gap];
            nextPos -= gap;
        }
        ints[nextPos] = nextVal;
    }
}
