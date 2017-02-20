package com.algo.F5.Redovisning;

import java.util.ArrayList;

/**
 * Created by timothy on 2017-02-03, com.algo.F5.Redovisning.
 */
public class Info {
    private ArrayList<Character> characterArrayList;
    private int steps;

    Info() {
        characterArrayList = new ArrayList<>();
        steps = 0;
    }

    Info(ArrayList<Character> characterArrayList, int steps) {
        this.characterArrayList = characterArrayList;
        this.steps = steps;
    }

    public void addStep() {
        steps += 1;
    }

    public int getSteps() {
        return steps;
    }

    public ArrayList<Character> getCharacterArrayList() {
        return ((ArrayList<Character>) characterArrayList.clone());
    }

    public void add(Character character) {
        characterArrayList.add(character);
    }
}
