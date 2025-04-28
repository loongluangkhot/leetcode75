package org.example.java;

import java.util.function.Consumer;

public interface IBinaryTree {
    void add(int n);
    int remove();
    void traverse(BinaryTraversalMode mode, Consumer<Integer> consumer);
    int size();
}

