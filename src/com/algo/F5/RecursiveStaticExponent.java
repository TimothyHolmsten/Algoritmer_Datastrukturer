package com.algo.F5;

/**
 * Created by timothy on 2017-01-30, com.algo.F5.
 */
public class RecursiveStaticExponent {
    public RecursiveStaticExponent() {

    }

    public static int calculate(int x, int n) {
        if (n == 0)
            return 1;
        if (n > 1)
            return x * calculate(x, n - 1);
        return x;
    }
}
