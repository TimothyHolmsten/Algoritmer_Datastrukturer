package com.algo.F11;

import com.algo.F11.Factory.Activity;
import com.algo.F11.Factory.Factory;
import com.algo.F11.NumberLine.NumberLine;
import com.algo.F11.NumberLine.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by timothy on 2017-02-20, com.algo.F11.
 */
public class Main {
    public static void main(String[] args) {
        int[] currency = ChangeProblem.change(789, new int[]{1000, 500, 100, 50, 20, 10, 5, 1});

        for (int i : currency)
            System.out.println(i);

        //KnapSack.pack(15, new Item[]{new Item(10, 4), new Item(3, 2), new Item(1, 1)});

        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity(9, 11));
        activities.add(new Activity(10, 12));
        activities.add(new Activity(10, 16));
        activities.add(new Activity(11, 17));
        activities.add(new Activity(15, 17));
        activities.add(new Activity(16, 22));
        activities.add(new Activity(22, 23));

        Factory factory = new Factory(activities);
        System.out.println("Workers: " + factory.calculateWorkersNeeded());
        //System.out.println(factory.getActivities().toString());

        ArrayList<Point> points = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < new Random().nextInt(10) + 5; i++) {
            last = new Random().nextInt(4) + last + 1;
            points.add(new Point(last));
        }
        System.out.println(points);
        System.out.println(new NumberLine(points).calculateLines());
    }
}
