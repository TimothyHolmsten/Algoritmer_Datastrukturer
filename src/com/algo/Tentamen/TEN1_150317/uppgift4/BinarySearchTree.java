package com.algo.Tentamen.TEN1_150317.uppgift4;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0)
            return false;
        else if (data.compareTo(node.data) < 0)
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            } else
                return add(data, node.left);
        else if (node.right == null) {
            node.right = new Node<E>(data);
            return true;
        } else
            return add(data, node.right);
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    public E find(E target) {
    }

    public void printTree() {
    }

    private static class Node<E> {
        private E data;
        private Node<E> left, right;

        private Node(E d) {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}
