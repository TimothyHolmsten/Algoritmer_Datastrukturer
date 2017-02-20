package com.algo.F7;

/**
 * Created by timothy on 2017-02-05, com.algo.F7.
 */
public class BinaryTree<E extends Comparable<E>> {
    private class Node<E> {
        private E data;
        private Node<E> left, right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": " + node.data);
            inOrder(node.right, sb);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        } else
            return add(data, root);
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) < 0)
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else
                return add(data, node.left);
        else if (data.compareTo(node.data) > 0)
            if (node.right == null) {
                node.right = new Node<>(data);
                return true;
            } else
                return add(data, node.right);
        return false;
    }

    public E find(E target) {
        return find(target, root);
    }

    private E find(E target, Node<E> node) {
        if (node == null)
            return null;
        if (target.compareTo(node.data) == 0)
            return node.data;
        else if (target.compareTo(node.data) < 0)
            return find(target, node.left);
        else
            return find(target, node.right);
    }

    private Node<E> findNodeBefore(E target, Node<E> node) {
        if (node == null)
            return null;
        if (node.left != null) {
            if (target.compareTo(node.left.data) == 0)
                return node;
        } else if (node.right != null) {
            if (target.compareTo(node.right.data) == 0)
                return node;
        }
        if (target.compareTo(node.data) < 0) {
            return findNodeBefore(target, node.left);
        } else
            return findNodeBefore(target, node.right);
    }

    public E remove(E target) {
        Node<E> nodeBefore = findNodeBefore(target, root);
        Node<E> nodeToRemove = null;
        if (nodeBefore.left != null) {
            if (target.compareTo(nodeBefore.left.data) == 0) {
                nodeToRemove = nodeBefore.left;
                nodeBefore.left = null;
            }
        } else if (nodeBefore.right != null) {
            if (target.compareTo(nodeBefore.right.data) == 0) {
                nodeToRemove = nodeBefore.right;
                nodeBefore.right = null;
            }
        }
        return remove(target, nodeToRemove);
    }

    private E remove(E target, Node<E> node) {
        if (find(target, node) != null) {
            E left = null;
            E right = null;
            if (node.left != null)
                left = remove(node.left.data, node.left);
            node.left = null;
            if (node.right != null)
                right = remove(node.right.data, node.right);
            node.right = null;
            if (right != null)
                add(right);
            if (left != null)
                add(left);
            return target;
        }
        return null;
    }

    public int numberOfLeaves() {
        return numberOfLeaves(0, root);
    }

    private int numberOfLeaves(int count, Node<E> node) {
        if (node.left == null && node.right == null) {// Must be leaf
            return 1;
        }
        if (node.left != null)
            count = numberOfLeaves(count, node.left);
        if (node.right != null)
            count = numberOfLeaves(count, node.right);
        return count;
    }

    public int numberOfNodes() {
        return numberOfNodes(0, root);
    }

    private int numberOfNodes(int count, Node<E> node) {
        int i = 0;
        if (node.left == null && node.right == null) { // Must be leaf
            return 0;
        }
        if (node.left != null)
            i += numberOfNodes(count, node.left) + 1;
        if (node.right != null)
            i += numberOfNodes(count, node.right) + 1;
        return i;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }
}
