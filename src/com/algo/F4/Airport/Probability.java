package com.algo.F4.Airport;

import java.security.SecureRandom;

/**
 * Created by timothy on 2017-01-27, com.algo.F4.Airport.
 */
public class Probability {
    private double probability;

    public Probability(double probability) {
        this.probability = probability;
    }

    public boolean query() {
        //return new Random().nextInt(100 / probability) == 0;
        return Math.random() < probability;
        //return new SecureRandom().nextDouble() < probability;
    }
}
