package com.algo.F9;

/**
 * Created by timothy on 2017-02-22, com.algo.F9.
 */
public class Quicksort {

    public static int[] sort(int[] table) {
        return sort(table, 0, table.length - 1);
    }

    private static int[] sort(int[] table, int first, int last) {

        if (first < last) {
            int pivot = partition(table, first, last);

            sort(table, first, pivot - 1);
            sort(table, pivot + 1, last);
        }
        return table;
    }

    private static int partition(int[] table, int first, int last) {
        Integer pivot = table[first];
        int up = first;
        int down = last;

        do {

            while ((up < last) && (pivot.compareTo(table[up]) >= 0))
                up++;

            while (pivot.compareTo(table[down]) < 0)
                down--;


            if (up < down) {
                int tmp = table[down];
                table[down] = table[up];
                table[up] = tmp;
            }
        } while (up < down);
        table[0] = table[down];
        table[down] = pivot;
        return down;
    }
}
