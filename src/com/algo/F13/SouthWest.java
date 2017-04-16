package com.algo.F13;

/**
 * Created by timothy on 2017-03-12, com.algo.F13.
 */
public class SouthWest {
    public static int calculate(int x, int y) {
        int[][] field = new int[x][y];
        return calculate(field, x - 1, 0);
    }

    private static int calculate(int[][] field, int x, int y) {

        if (x < 0 || y > field[0].length - 1)
            return 0;

        if (y == field[0].length - 1 && x == 0)
            return 1;

        if (field[x][y] != 0)
            return field[x][y];

        return calculate(field.clone(), x, y + 1) + calculate(field.clone(), x - 1, y);
    }
}
