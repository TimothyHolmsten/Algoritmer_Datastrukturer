package com.algo.F6;

/**
 * Created by timothy on 2017-03-09, com.algo.F6.
 */
public class Puzzle {
    final private static int[][] NORTHEAST = {{1, 1}, {1, 0}};
    final private static int[][] NORTHWEST = {{1, 1}, {0, 1}};
    final private static int[][] SOUTHEAST = {{1, 0}, {1, 1}};
    final private static int[][] SOUTHWEST = {{0, 1}, {1, 1}};

    final private static int GAMEFIELDLENGTH = 5;
    final private static int[][] GAMEFIELD = new int[GAMEFIELDLENGTH][GAMEFIELDLENGTH];

    public static int calculate(int positionX, int positionY) {
        GAMEFIELD[positionX][positionY] = 1;
        int[][] field = GAMEFIELD.clone();
        return calculate(field, 0, 0, 0, 0) +
                calculate(field, 1, 0, 0, 0) +
                calculate(field, 2, 0, 0, 0) +
                calculate(field, 3, 0, 0, 0);
    }

    private static int calculate(int[][] tmpField, int brick, int positionX, int positionY, int depth) {
        if (positionY == 5) {
            if (isSolved(tmpField))
                return 1;
            return 0;
        }

        int[][] whatBrick = null;
        int[][] field = tmpField.clone();

        switch (brick) {
            case 0:
                whatBrick = NORTHEAST;
                break;
            case 1:
                whatBrick = NORTHWEST;
                break;
            case 2:
                whatBrick = SOUTHEAST;
                break;
            case 3:
                whatBrick = SOUTHWEST;
                break;
        }

        if (doesFit(tmpField, whatBrick, positionX, positionY)) {
            insertBrick(tmpField, whatBrick, positionX, positionY);
            if (positionX == 4) {
                positionX = -1;
                positionY++;
            }

            return calculate(field, 0, positionX + 1, positionY, depth + 1) +
                    calculate(field, 1, positionX + 1, positionY, depth + 1) +
                    calculate(field, 2, positionX + 1, positionY, depth + 1) +
                    calculate(field, 3, positionX + 1, positionY, depth + 1);
        }
        return 0;
    }

    private static boolean doesFit(int[][] field, int[][] brick, int positionX, int positionY) {
        for (int y = positionY; y < positionY + 1; y++)
            for (int x = positionX; x < positionX + 1; x++)
                if (brick[x % 2][y % 2] != 0 && field[x][y] != 0)
                    return false;
        return true;
    }

    private static boolean isSolved(int[][] field) {
        for (int y = 0; y < GAMEFIELDLENGTH; y++)
            for (int x = 0; x < GAMEFIELDLENGTH; x++)
                if (field[x][y] == 0)
                    return false;
        return true;
    }

    private static void insertBrick(int[][] field, int[][] brick, int positionX, int positionY) {
        for (int y = positionY; y < positionY + 1; y++)
            for (int x = positionX; x < positionX + 1; x++)
                field[x][y] = brick[x % 2][y % 2];
    }

}
