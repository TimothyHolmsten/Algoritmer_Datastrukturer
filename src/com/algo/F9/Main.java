package com.algo.F9;

/**
 * Created by timothy on 2017-02-14, com.algo.F9.
 */
public class Main {
    public static void main(String[] args) {
        int[] sel = {9,7,6,4,3,8};

        sel = ShellSort.sort(sel);

        for(int i: sel)
            System.out.println(i);
    }

}
