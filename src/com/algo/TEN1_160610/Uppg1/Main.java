package com.algo.TEN1_160610.Uppg1;

public class Main {

    public static void main(String[] args) {
        System.out.println("Siffersumma:" + digitSum(2456));

    }

    public static int digitSum(int number) {
        if (number == 0) return 0;
        return number % 10 + digitSum(number / 10);
    }

}

