package com.algo.F9;

/**
 * Created by timothy on 2017-02-14, com.algo.F9.
 */
public class Main {
    public static void main(String[] args) {
        int[] sel = {44, 75, 23, 43, 55, 12, 64, 77, 33};

        sel = Quicksort.sort(sel);

        for (int i : sel)
            System.out.println(i);
    }

}
