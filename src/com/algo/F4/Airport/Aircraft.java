package com.algo.F4.Airport;

/**
 * Created by timothy on 2017-01-27, com.algo.F4.Airport.
 */
public class Aircraft {
    private int waitTime;

    public Aircraft() {
        waitTime = 0;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void updateWaitTime(int time) {
        waitTime += time;
    }
}
