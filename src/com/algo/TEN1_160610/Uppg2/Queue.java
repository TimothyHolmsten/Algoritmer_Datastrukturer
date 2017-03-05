package com.algo.TEN1_160610.Uppg2;

/**
 * Created by timothy on 2017-03-03, com.algo.TEN1_160610.Uppg2.
 */
public class Queue<E> {
    private Node<E> first, last;

    public Queue() {
        first = null;
        last = null;
    }

    public int size() {
        return size(first);
    }

    private int size(Node<E> node) {
        if (node.next == null) return 0;
        return 1 + size(node.next);
    }

    public E dequeue() {
        if (first != null) {
            E data = first.data;
            first = first.next;
            return data;
        }
        return null;
    }

    public void enqueue(E obj) {
        if (first == null)
            first = new Node<>(obj, null);
        else if (first.next == null) {
            first.next = last = new Node<>(obj, null);
        } else
            last.next = last = new Node<>(obj, null);
    }

    private class Node<E> {
        private E data = null;
        private Node<E> next = null;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
