package com.algo.Tentamen.TEN1_150612.Uppg4;

/**
 * Created by timothy on 2017-03-13, com.algo.Tentamen.TEN1_150612.Uppg4.
 */
public class Platta {
    public static int calculate(int[] plattor, int distance) {
        if (distance == 0)
            return 1;
        int counter = 0;

        for (int i = plattor.length - 1; i >= 0; i--)
            if (distance - plattor[i] >= 0) {
                counter += calculate(plattor, distance - plattor[i]);
            }
        return counter;
    }
}
