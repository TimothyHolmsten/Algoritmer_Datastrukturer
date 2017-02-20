package com.algo.F7;

/**
 * Created by timothy on 2017-02-06, com.algo.F7.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(5);
        for(int i = 0; i < 20; i++)
            binaryTree.add(i);
        System.out.println(binaryTree);

        System.out.println(binaryTree.find(9));
        //binaryTree.remove(0);
        //System.out.println(binaryTree.find(-1));
        System.out.println(binaryTree);
        System.out.println(binaryTree.numberOfLeaves());
        System.out.println(binaryTree.numberOfNodes());
    }

}
