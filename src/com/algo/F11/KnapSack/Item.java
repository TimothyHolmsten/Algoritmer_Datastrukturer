package com.algo.F11.KnapSack;

/**
 * Created by timothy on 2017-02-20, com.algo.F11.KnapSack.
 */
public class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("value: %d : weight: %d", value, weight);
    }
}
