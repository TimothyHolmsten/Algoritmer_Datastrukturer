package com.algo.F11.NumberLine;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by timothy on 2017-02-21, com.algo.F11.NumberLine.
 */
public class NumberLine {
    private ArrayList<Point> points;

    public NumberLine(ArrayList<Point> p) {
        points = p;
    }

    public int calculateLines() {
        int currentX = points.get(0).getX();
        int lines = 0;
        for(Point p: points)
            if(p.getX() > currentX + 2) {
                lines++;
                currentX = p.getX();
            }
        return lines + 1;
    }
}
