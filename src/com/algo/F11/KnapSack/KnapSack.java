package com.algo.F11.KnapSack;

import java.util.ArrayList;

/**
 * Created by timothy on 2017-02-20, com.algo.F11.
 */
public class KnapSack {
    public static void pack(int weight, Item[] items) {
        ArrayList<Item> packed = new ArrayList<>();
        Item[] sorted = new Item[items.length];

        double cost = 0;
        for (int j = 0; j < items.length; j++) {
            int cost_item = -1;
            for (int i = 0; i < items.length; i++)
                if (items[i] != null && (double) (items[i].getValue() / items[i].getWeight()) > cost) {
                    cost = (double) (items[i].getValue() / items[i].getWeight());
                    cost_item = i;
                }
            if (cost_item == -1)
                break;
            sorted[j] = items[cost_item];
            items[cost_item] = null;
        }
        while (weight > 0)
            for (Item aSorted : sorted)
                if (weight - aSorted.getWeight() >= 0) {
                    packed.add(aSorted);
                    weight -= aSorted.getWeight();
                }
        System.out.println(packed);

    }

}
