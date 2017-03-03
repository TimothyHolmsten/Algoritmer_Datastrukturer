package com.algo.F2;

import java.util.Iterator;

/**
 * Created by timothy on 2017-01-24, com.algo.F2.
 */
public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add("Timothy");
        singleLinkedList.add("Chatarina");
        singleLinkedList.add("Nicholas");
        singleLinkedList.add("Joakim");
        System.out.println(singleLinkedList);

        singleLinkedList.remove(0);
        singleLinkedList.remove(0);
        System.out.println(singleLinkedList);

        singleLinkedList.add(0, "Timothy");
        singleLinkedList.add(1, "Chatarina");
        System.out.println(singleLinkedList);

        singleLinkedList.remove(3);
        singleLinkedList.remove(2);
        System.out.println(singleLinkedList);

        Iterator<String> iterator = singleLinkedList.iterator();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        System.out.println(singleLinkedList);

        /*
        No tail
         */
        System.out.println("\n_______________________ [No tail] _______________________\n");

        SingleLinkedListNoTail<String> singleLinkedListNoTail = new SingleLinkedListNoTail<>();
        singleLinkedListNoTail.add("Timothy");
        singleLinkedListNoTail.add("Chatarina");
        singleLinkedListNoTail.add("Nicholas");
        singleLinkedListNoTail.add("Joakim");
        System.out.println(singleLinkedListNoTail);

        singleLinkedListNoTail.remove(0);
        singleLinkedListNoTail.remove(0);
        System.out.println(singleLinkedListNoTail);

        singleLinkedListNoTail.add(0, "Timothy");
        singleLinkedListNoTail.add(1, "Chatarina");
        System.out.println(singleLinkedListNoTail);

        //singleLinkedListNoTail.remove(3);
        //singleLinkedListNoTail.remove(2);
        System.out.println(singleLinkedListNoTail);

        Iterator<String> iterator1 = singleLinkedListNoTail.iterator();
        iterator1.next();
        iterator1.remove();
        iterator1.next();
        iterator1.remove();
        System.out.println(singleLinkedListNoTail);



        /*
        Niclas test
         */
        SingleLinkedList<String> niclas = new SingleLinkedList<>();
        for (int i = 0; i < 4; i++) {
            niclas.add("" + i);

        }
        niclas.remove(3);
        niclas.add(0, "start");
        niclas.add("sist");
        System.out.println(niclas);

        /*
        Niclas 3
         */

        SingleLinkedListNoTail<String> nicke = new SingleLinkedListNoTail<>();
        for (int i = 0; i < 4; i++) {
            nicke.add("" + i);
        }
        System.out.println(nicke);
        Iterator<String> nickeItr = nicke.iterator();
        //nickeItr.next();
        nickeItr.remove();
        nickeItr.next();
        nickeItr.remove();
        System.out.println(nicke);
    }
}
