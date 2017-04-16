package com.algo.Tentamen.TEN1_150317.uppgift1;

public class SingleLinkedList<E> {

    private Node<E> head;
    //private int size;

    public SingleLinkedList() {
        head = null;
        //size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    private void addFirst(E item) {
        head = new Node<E>(item, head);
    }

    /*private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }*/

    private Node<E> getNode(int index) {
        if (index >= size() || index < 0)
            return null;
        return getNode(index, head);
    }

    private Node<E> getNode(int index, Node<E> node) {
        if (index == 0)
            return node;
        if (node.next != null)
            return getNode(index - 1, node.next);
        return null;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
    }

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }*/

    @Override
    public String toString() {
        if (head != null)
            return toString(head, new StringBuilder());
        return null;
    }

    private String toString(Node<E> node, StringBuilder sb) {
        if (node.next == null) {
            sb.append(node.data);
            return sb.toString();
        }

        sb.append(node.data + "=>");
        return toString(node.next, sb);
    }

    public int size() {
        if (head == null)
            return 0;
        return size(head);
    }

    private int size(Node<E> node) {
        if (node.next == null)
            return 1;
        return size(node.next) + 1;
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

