package com.algo.F9;

import java.util.Comparator;

/**
 * Created by timothy on 2017-02-14, com.algo.F9.
 */
public class CompareCar implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.compareTo(o2); // Just change compareTo to compare yearModel
    }

}
