package com.algo.TEN1_160324.Uppg2;


public class Main {

    public static void buildTree(BinarySearchTree<Integer> b) {
        b.add(4);
        b.add(2);
        b.add(8);
        b.add(3);
        b.add(5);
        b.add(7);
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        buildTree(bst);
        System.out.println(bst.minLeaf());
        System.out.println(bst.toString());
    }

}
