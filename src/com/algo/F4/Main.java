package com.algo.F4;

/**
 * Created by timothy on 2017-01-26, com.algo.F4.
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(10);

        for(int i = 0; i < 10; i++)
            arrayQueue.offer(""+i);
        System.out.println(arrayQueue);
        arrayQueue.offer("Hej");
        System.out.println(arrayQueue);
        for(int i = 0; i < 6; i++)
            arrayQueue.poll();
        System.out.println(arrayQueue);
        arrayQueue.poll();
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.getSize());
    }

}
