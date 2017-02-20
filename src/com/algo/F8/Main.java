/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.F8;

/**
 * @author bfelt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTableBucket<Integer, Integer> table = new HashTableBucket<>(10);
        for (int i = 0; i < 30; i += 1) {
            table.put(i, i);
        }
        //System.out.println(table);
        /*for (int i = 0; i < 100; i++) {
            if(i%3==0)
                table.remove(i);
        }*/
        //System.out.println(table);
        //System.out.println(table.get(22));
        System.out.println(table);
    }

}
