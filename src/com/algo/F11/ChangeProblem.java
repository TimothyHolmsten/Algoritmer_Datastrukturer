package com.algo.F11;

/**
 * Created by timothy on 2017-02-20, com.algo.F11.
 */
public class ChangeProblem {
    public static int[] change(int value, int[] currency) {
        int[] change = new int[currency.length];

        while (value > 0)
            for (int i = 0; i < currency.length; i++)
                if (value - currency[i] >= 0) {
                    value -= currency[i];
                    change[i]++;
                }

        return change;
    }
}
