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
        return find(target, root);
    }

    private E find(E target, Node<E> node) {
        while (node != null) {
            if (target.compareTo(node.data) < 0)
                node = node.left;
            else if (target.compareTo(node.data) > 0)
                node = node.right;
            else
                return node.data;
        }
        return null;
    }

    public void printTree() {
        StringBuilder sb = new StringBuilder();
        printTree(root, sb);
        System.out.println(sb.toString());
    }

    private void printTree(Node<E> node, StringBuilder sb) {

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
