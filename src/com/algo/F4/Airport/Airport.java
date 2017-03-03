package com.algo.F4.Airport;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by timothy on 2017-01-27, com.algo.F4.Airport.
 */
public class Airport {
    private Queue<Aircraft> landingQueue;
    private Queue<Aircraft> startingQueue;
    private LinkedList<Aircraft> Aircrafts;
    private final static int TENYEARS = 24 * 60 * 365 * 10;
    private Probability landingProb;
    private Probability startingProb;

    private int totalLandingTime;
    private int totalStartingTime;
    private int totalAircraftLanded;
    private int totalAircraftStarted;
    private int maximalLandTime;
    private int maximalStartTime;

    public Airport() {
        landingQueue = new LinkedList<>();
        startingQueue = new LinkedList<>();
        Aircrafts = new LinkedList<>();

        landingProb = new Probability(0.05);
        startingProb = new Probability(0.05);

        totalAircraftLanded = 0;
        totalLandingTime = 0;
        totalAircraftStarted = 0;
        totalStartingTime = 0;

        maximalLandTime = 0;
        maximalStartTime = 0;
    }

    public String runSimulation() {
        int ticker = 0;
        for (int t = 0; t < TENYEARS; t += 5) {

            //if (startingProb.query()) {
            if (t == 0) {
                Aircraft aircraft = new Aircraft();
                startingQueue.offer(aircraft);
                Aircrafts.add(aircraft);
            }
            if (t == 5) {
                //if (landingProb.query()) {
                Aircraft aircraft = new Aircraft();
                landingQueue.offer(aircraft);
                Aircrafts.add(aircraft);
            }

            if (ticker == 0) {
                if (landingQueue.peek() != null) {
                    Aircraft aircraft = landingQueue.poll();
                    ticker = 3;
                    totalLandingTime += aircraft.getWaitTime();
                    totalAircraftLanded++;

                    if (aircraft.getWaitTime() > maximalLandTime)
                        maximalLandTime = aircraft.getWaitTime();

                    Aircrafts.remove(aircraft);
                } else if (startingQueue.peek() != null) {
                    Aircraft aircraft = startingQueue.poll();
                    ticker = 3;
                    totalStartingTime += aircraft.getWaitTime();
                    totalAircraftStarted++;

                    if (aircraft.getWaitTime() > maximalStartTime)
                        maximalStartTime = aircraft.getWaitTime();

                    Aircrafts.remove(aircraft);
                }

            } else
                ticker--;

            for (Aircraft a : Aircrafts) {
                a.updateWaitTime(5);
            }
        }
        System.out.println("Average landing time: " + (float) totalLandingTime / totalAircraftLanded);
        System.out.println("Average takeoff time: " + (float) totalStartingTime / totalAircraftStarted);
        System.out.println("Maximal landing time: " + maximalLandTime);
        System.out.println("Maximal takeoff time: " + maximalStartTime);
        return "";
    }
}