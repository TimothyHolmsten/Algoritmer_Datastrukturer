package com.algo.F11;

import com.algo.F11.KnapSack.Item;
import com.algo.F11.KnapSack.KnapSack;

/**
 * Created by timothy on 2017-02-20, com.algo.F11.
 */
public class Main {
    public static void main(String[] args) {
        int[] currency = ChangeProblem.change(789, new int[]{1000, 500, 100, 50, 20, 10, 5, 1});

        for (int i : currency)
            System.out.println(i);

        KnapSack.pack(15, new Item[]{new Item(10, 4), new Item(3, 2), new Item(1, 1)});
    }
}
