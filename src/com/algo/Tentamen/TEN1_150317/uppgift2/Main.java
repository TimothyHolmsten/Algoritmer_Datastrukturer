package com.algo.Tentamen.TEN1_150317.uppgift2;

public class Main {

    public static void main(String[] args) {
        int t = -1;
        int[][] pyramid = {{5, t, t, t, t, t, t, t, t, t},
                {3, 1, t, t, t, t, t, t, t, t},
                {4, 7, 6, t, t, t, t, t, t, t},
                {6, 8, 0, 9, t, t, t, t, t, t},
                {9, 2, 3, 5, 4, t, t, t, t, t},
                {8, 0, 5, 6, 1, 2, t, t, t, t},
                {2, 9, 7, 1, 0, 3, 5, t, t, t},
                {0, 7, 1, 6, 2, 9, 4, 8, t, t},
                {6, 1, 5, 0, 4, 2, 7, 9, 3, t},
                {9, 3, 2, 7, 8, 6, 4, 1, 5, 0}};

        solve(pyramid);

    }


}
