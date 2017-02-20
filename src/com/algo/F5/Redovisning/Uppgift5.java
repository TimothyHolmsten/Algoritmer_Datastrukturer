package com.algo.F5.Redovisning;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by timothy on 2017-02-03, com.algo.F5.Redovisning.
 */
public class Uppgift5 {
    public Uppgift5() {
    }

    private Info solve(LinkedList<Box> boxLinkedList, Info info) {
        if (info.getSteps() > 20)
            return new Info(null, Integer.MAX_VALUE);
        boolean shouldMove = false;
        for (int i = 0; i < boxLinkedList.size() - 1; i++)
            if (boxLinkedList.get(i).getValue() > boxLinkedList.get(i + 1).getValue()) {
                shouldMove = true;
                break;
            }
        if (shouldMove) {
            Info valueA = new Info(info.getCharacterArrayList(), Integer.MAX_VALUE);
            Info valueB = new Info(info.getCharacterArrayList(), Integer.MAX_VALUE);

            LinkedList<Box> tmpB = ((LinkedList<Box>) boxLinkedList.clone());
            tmpB.addFirst(tmpB.remove(1)); // Moves second to first and first to second because of linkedlist :)
            Info B = new Info(info.getCharacterArrayList(), info.getSteps());
            B.addStep();
            B.add('b');
            valueA = solve(tmpB, B);

            LinkedList<Box> tmpS = ((LinkedList<Box>) boxLinkedList.clone());
            tmpS.addFirst(tmpS.removeLast());
            Info S = new Info(info.getCharacterArrayList(), info.getSteps());
            S.addStep();
            S.add('s');
            valueB = solve(tmpS, S);

            if (Math.min(valueA.getSteps(), valueB.getSteps()) == valueA.getSteps())
                return valueA;
            else
                return valueB;
        } else
            return info;
    }

    public Info solve(String string) {
        LinkedList<Box> boxLinkedList = new LinkedList<>();
        for (int i = 0; i < string.length(); i++)
            boxLinkedList.add(new Box(string.charAt(i)));
        return solve(boxLinkedList, new Info());
    }

}
