package com.algo.Tentamen.TEN1_150317.uppgift1;


public class Main {

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        System.out.println(list + " " + list.size());
        for (int i = 0; i <= 3; i++)
            list.add(i, "Sträng " + (i + 1));
        list.add(0, "först");
        list.add(5, "sist");
        System.out.println(list + "" + list.size());
    }

}
