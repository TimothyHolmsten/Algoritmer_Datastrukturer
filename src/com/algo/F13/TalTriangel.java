package com.algo.F13;

/**
 * Created by timothy on 2017-03-04, com.algo.F13.
 */
public class TalTriangel {
    public static int maxValue(int[] triangle) {
        // alreadyKnown size is not optimized at all
        return maxValue(triangle, 0, 0, new int[(int) Math.pow(2, ((triangle.length) / 2))]);
    }

    private static int maxValue(int[] triangle, int position, int depth, int[] alreadyKnown) {
        if (position >= triangle.length - 1) {
            return 0;
        }
        if (alreadyKnown[position] != 0)
            return alreadyKnown[position];

        int left = maxValue(triangle, position + 1 + depth, depth + 1, alreadyKnown) + triangle[position];
        int right = maxValue(triangle, position + 2 + depth, depth + 1, alreadyKnown) + triangle[position];

        return alreadyKnown[position] = Math.max(left, right);
    }
}
