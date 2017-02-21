package com.algo.F11.Factory;

import java.util.ArrayList;

/**
 * Created by timothy on 2017-02-20, com.algo.F11.
 */
public class Factory {
    private ArrayList<Activity> activities;

    public Factory(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public ArrayList<Activity> getActivities() {
        return ((ArrayList<Activity>) activities.clone());
    }

    /*
    No idea what I have been doing, works with my example....
    Should work if the activities are sorted, the algorithm does not sort it... but it can be implemented :)
     */
    public int calculateWorkersNeeded() {
        int workers = 0;
        int cost;
        Activity removeActivity = null;
        for (int i = 0; i < activities.size(); i++) {
            cost = Integer.MAX_VALUE;
            for (Activity a : activities)
                if (activities.get(i).getEndTime() <= a.getStartTime() && a.getStartTime() - activities.get(i).getEndTime() < cost) {
                    removeActivity = a;
                    cost = a.getStartTime() - activities.get(i).getEndTime();
                }
            if (removeActivity != null) {
                activities.remove(activities.get(i));
                activities.remove(removeActivity);
                removeActivity = null;
                i = 0;
            }
            workers++; // Will add a worker in any case
        }
        return workers;
    }
}
