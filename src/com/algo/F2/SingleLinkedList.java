package com.algo.F2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by timothy on 2017-01-20, com.algo.F2.
 */
public class SingleLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    private void addLast(E item) {
        Node<E> newTail = new Node<E>(item, null);
        tail.next = newTail;
        tail = newTail;
        size++;
    }

    private Node<E> previousNode(Node<E> node) {
        if (head == node)
            return null;
        Node<E> prev = head;

        while (prev.next != null) {
            if (prev.next == node)
                return prev;
            else
                prev = prev.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
        add(size, e);
        return true;
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        return getNode(index).data;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (size == 0) {
            addFirst(item);
            tail = getNode(0);
        } else if (index == 0)
            addFirst(item);
        else if (index == size)
            addLast(item);
        else {
            Node<E> foundNode = getNode(index - 1);
            addAfter(foundNode, item);
        }
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }


    public E remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Wrong index");

        if (index == 0)
            return unlink(head, null);
        else if (index == size - 1)
            return unlink(tail, previousNode(tail));

        final Node<E> prev = getNode(index - 1);
        final Node<E> removeNode = prev.next;
        return unlink(removeNode, prev);
    }

    private E unlink(Node<E> removeNode, Node<E> prev) {
        if (removeNode == null)
            throw new NullPointerException("Node not found");

        if (prev != null)
            prev.next = removeNode.next;

        if (tail == removeNode) {
            tail = prev;
        } else if (head == removeNode)
            head = removeNode.next;

        final E nodeData = removeNode.data;
        removeNode.data = null; // May be unnecessary since garbage collector will not use this?
        removeNode.next = null;
        size--;
        return nodeData;
    }

    private Node<E> getNode(int index) {
        if (index == size - 1 && tail != null)
            return tail;
        if (index == 0 && size > 0)
            return head;

        Node<E> node = head;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> node = head;
        if (node != null) {
            while (node.next != null) {
                sb.append(node.data.toString());
                sb.append("==>");
                node = node.next;
            }
            sb.append(node.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        private E data;

        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {//nested class – ligger i SingleLinkedList
        Node<E> current;
        Node<E> beforeCurrent;
        Node<E> beforeBeforeCurrent;

        Itr(Node<E> start) {
            current = start;
            beforeCurrent = null;
            beforeBeforeCurrent = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            if (current != head)
                beforeBeforeCurrent = beforeCurrent;
            beforeCurrent = current;
            current = current.next;
            return returnValue;
        }

        @Override
        public void remove() {
            if (beforeBeforeCurrent == beforeCurrent)
                throw new IllegalStateException();
            beforeCurrent = beforeBeforeCurrent;
            if (beforeCurrent != null)
                beforeCurrent.next = current;
            else
                head = current;
            size--;

        }
    }

}