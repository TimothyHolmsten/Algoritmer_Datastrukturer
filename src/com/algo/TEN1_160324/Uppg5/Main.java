package com.algo.TEN1_160324.Uppg5;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maxValue(20, new int[]{13, 11, 10, 5, 4}, new int[]{9, 8, 7, 4, 3})); //28

        System.out.println(maxValue(117, new int[]{13, 11, 10, 5, 4}, new int[]{9, 8, 7, 4, 3})); //169

        System.out.println(maxValue(30, new int[]{10, 22}, new int[]{10, 21})); //30
    }

    static int maxValue(int totalWeight, int[] value, int[] weight) {

        int[] maxValue = new int[totalWeight + 1];
        for (int i = 0; i < value.length; i++)
            for (int m = 1; m <= totalWeight; m++)
                if (weight[i] <= m && maxValue[m] < maxValue[m - weight[i]] + value[i])
                    maxValue[m] = value[i] + maxValue[m - weight[i]];
        return maxValue[totalWeight];
    }

}