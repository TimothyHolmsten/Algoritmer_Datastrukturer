package com.algo.F4;

/**
 * Created by timothy on 2017-01-25, com.algo.F4.
 */
public class ArrayQueue<E> {
    private int front, rear, size, maxSize;
    private E[] data;

    public ArrayQueue(int initialMaxSize) {
        size = 0;
        front = 0;
        maxSize = initialMaxSize;
        rear = maxSize - 1;

        data = ((E[]) new Object[maxSize]);
    }

    public boolean offer(E element) {
        if (size + 1 > maxSize)
            reallocate();
        rear = ++rear % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    public E peek() {
        if (size == 0)
            return null;
        return data[front];
    }

    public E poll() {
        if (size == 0)
            return null;
        if (size == maxSize / 4)
            deallocate();
        E tmpData = data[front];
        front = ++front % maxSize;
        size--;
        return tmpData;
    }

    private void reallocate() {
        E[] oldData = data;
        data = ((E[]) new Object[maxSize * 2]);
        int j = 0;
        for (int i = front; i < maxSize + front; i++)
            data[j++] = oldData[i % maxSize];
        maxSize *= 2;
        front = 0;
        rear = size - 1;
    }

    private void deallocate() {
        E[] oldData = data;
        data = ((E[]) new Object[maxSize / 2]);
        int j = 0;
        for (int i = front; i < size + front; i++) {
            data[j++] = oldData[i % maxSize];
        }
        maxSize /= 2;
        front = 0;
        rear = size - 1;

    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = front; i < size + front; i++)
            sb.append(data[i % maxSize] + "=>");
        return sb.toString();
    }
}
