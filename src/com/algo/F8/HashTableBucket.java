/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.F8;

/**
 * @param <K>
 * @param <V>
 * @author bfelt
 */
public class HashTableBucket<K, V> {

    private static class Entry<K, V> {

        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public String toString() {
            return String.format("[Key %s, Value %s]", key, value);
        }

    }

    private SingleLinkedList<Entry<K, V>>[] table;
    private static final float MAXLOAD = 0.75f;
    private int nrEntries, capacity;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int initialSize) {
        capacity = initialSize;
        table = new SingleLinkedList[initialSize];
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new SingleLinkedList<>();
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        table[index].addFirst(new Entry<>(key, value));
        nrEntries++;
        if (nrEntries > capacity * MAXLOAD)
            reHash();
        return null;
    }

    private void reHash() {
        capacity *= 2;
        SingleLinkedList<Entry<K, V>>[] oldTable = table;
        table = new SingleLinkedList[capacity];
        nrEntries = 0;
        for (SingleLinkedList<Entry<K, V>> list : oldTable)
            if (list != null)
                for (Entry<K, V> entry : list)
                    put(entry.key, entry.value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++)
            if (table[i] != null)
                sb.append(table[i].toString() + "\n");
        return sb.toString();
    }
}
