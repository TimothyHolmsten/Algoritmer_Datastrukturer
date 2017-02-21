package com.algo.F11.Factory;

/**
 * Created by timothy on 2017-02-20, com.algo.F11.Factory.Factory.
 */
public class Activity {
    private int startTime;
    private int endTime;

    public Activity(int start, int end) {
        startTime = start;
        endTime = end;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "start: " + startTime + " end: " + endTime;
    }
}
