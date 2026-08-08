package org.example.leetcode;

public class Pair<K,V> {
    public K item1;
    public V item2;
    public Pair(K item1, V item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public K getKey() {
        return item1;
    }

    public V getValue() {
        return item2;
    }
}
