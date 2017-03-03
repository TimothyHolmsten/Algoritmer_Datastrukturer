package com.algo.TEN1_160324.Uppg1;

public class SingleLinkedList<E> {

    private Node<E> head;

    public SingleLinkedList() {
        head = null;
    }

    private void addFirst(E item) {
        head = new Node<E>(item, head);
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
    }

    private Node<E> getNode(int index) {
        if (head == null) return null;

        Node<E> node = head;
        for (int i = 0; i < index && node.next != null; i++)
            node = node.next;
        return node;
    }

    public E get(int index) {
        Node<E> node = getNode(index);

        if (node != null)
            return node.data;
        return null;
    }

    public void add(int index, E item) {
        if (index <= 0 || head == null) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public int size() {
        return size(head);
    }

    private int size(Node<E> node) {
        if (node == null) return 0;

        return 1 + size(node.next);
    }

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }
}
