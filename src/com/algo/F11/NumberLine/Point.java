package com.algo.F11.NumberLine;

/**
 * Created by timothy on 2017-02-21, com.algo.F11.NumberLine.
 */
public class Point {
    private int x;

    public Point(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "" + x;
    }
}
