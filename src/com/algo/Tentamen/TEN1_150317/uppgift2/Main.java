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

    public static void solve(int[][] pyramid) {
        int[] visited = new int[pyramid[0].length];
        int[] order = new int[pyramid[0].length];

        if (solve(pyramid, visited, order, 0, 0))
            for (int i : order)
                System.out.println(i);
        else
            System.out.println("No solution");

    }

    private static boolean solve(int[][] pyramid, int[] visited, int[] order, int x, int y) {
        if (visited[pyramid[y][x]] != 0)
            return false;
        visited[pyramid[y][x]] = 1;
        order[y] = pyramid[y][x];
        if (y == pyramid[0].length - 1)
            return true;
        else {

            if (x < pyramid.length - 1 && pyramid[y + 1][x + 1] != -1)
                if (solve(pyramid, visited.clone(), order, x + 1, y + 1))
                    return true;
            if (x >= 0 && pyramid[y][x] != -1)
                if (solve(pyramid, visited.clone(), order, x, y + 1))
                    return true;
            return false;
        }
    }


}
