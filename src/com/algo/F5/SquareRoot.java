package com.algo.F5;

/**
 * Created by timothy on 2017-01-30, com.algo.F5.
 */
public class SquareRoot {
    public static double squareRoot(double n, double a, double e) {
        if (Math.abs(a * a - n) < e)
            return a;
        return squareRoot(n, (a * a + n) / (2 * a), e);
    }
}
