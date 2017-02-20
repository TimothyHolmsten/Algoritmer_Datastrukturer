package com.algo;

import com.algo.F2.SingleLinkedList;
import com.algo.F2.SingleLinkedListNoTail;
import com.algo.F3.PostfixEvaluator;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        int r = 0, p = 40;
        int n = 20;
        //for (int n = 1; n <= p; n++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++)
                    for (int k = j; k <= i + j; k++)
                        for (int m = 1; m <= i + j - k; m++)
                            r++;//Enkel sats
                array.add(r);
            }
        //}
        System.out.println(array);

        SingleLinkedListNoTail<Integer> singleLinkedList = new SingleLinkedListNoTail<>();
        singleLinkedList.add(20);
        singleLinkedList.add(10);
        singleLinkedList.add(50);
        singleLinkedList.add(1337);
        System.out.println("hej");
        singleLinkedList.add(3, 45);

        System.out.println(singleLinkedList.toString());

        //singleLinkedList.remove(2);
        System.out.println(singleLinkedList.toString());

        singleLinkedList.add(2, 666);
        singleLinkedList.add(2, 999);
        singleLinkedList.add(7331);

        System.out.println(singleLinkedList.toString());

        Iterator<Integer> itr = singleLinkedList.iterator();

        while (itr.hasNext()) {
            int i = itr.next();
            if (i == 20 || i == 7331)
                itr.remove();


        }

        System.out.println(singleLinkedList.toString());


        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
        try {
            System.out.println(postfixEvaluator.eval("5 5 / 5 5 + 100 10 *"));
        } catch (PostfixEvaluator.SyntaxErrorException e) {
            e.printStackTrace();
        }
    }
}
