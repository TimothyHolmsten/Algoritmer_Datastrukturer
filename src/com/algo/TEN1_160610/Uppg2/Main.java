package com.algo.TEN1_160610.Uppg2;

public class Main {

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.dequeue();
        q.enqueue("test");
        System.out.println(q.dequeue() + " " + q.dequeue());
        for (int i = 0; i < 8; i++)
            q.enqueue("e" + (i + 1));
        q.dequeue();
        q.dequeue();
        for (int i = 8; i < 14; i++)
            q.enqueue("e" + (i + 1));
        System.out.println("storlek: " + q.size());
        while (q.size() != 0)
            System.out.println(q.dequeue());
    }

}
