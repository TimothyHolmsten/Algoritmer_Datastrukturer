package com.algo.F5.Redovisning;

/**
 * Created by timothy on 2017-02-03, com.algo.F5.Redovisning.
 */
public class Box {
    private Character character;
    private int value;

    Box(Character character) {
        this.character = character;
        value = Character.getNumericValue(character);
    }

    public Character getCharacter() {
        return character;
    }

    public int getValue() {
        return value;
    }
}
