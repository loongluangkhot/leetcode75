package org.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BinaryTree implements IBinaryTree {
    final ArrayList<Integer> tree;

    public BinaryTree() {
        tree = new ArrayList<>();
    }

    public BinaryTree(int[] tree) {
        this.tree = Arrays.stream(tree).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    int getParentIndex(int i) {
        return i == 0 ? -1 : (i - 1) / 2;
    }

    int getLeftIndex(int i) {
        return getRightIndexWithOffset(i, -1);
    }

    int getRightIndex(int i) {
        return getRightIndexWithOffset(i, 0);
    }

    private int getRightIndexWithOffset(int i, int offset) {
        var index = (i + 1) * 2 + offset;
        return index >= tree.size() ? -1 : index;
    }

    @Override
    public void add(int n) {
        tree.add(n);
    }

    @Override
    public int remove() {
        return tree.removeLast();
    }

    @Override
    public void traverse(BinaryTraversalMode mode, Consumer<Integer> consumer) {
        IBinaryTreeTraversalConsumer innerConsumer = (t,i) -> consumer.accept(t.get(i));
        if (mode == BinaryTraversalMode.IN_ORDER) {
            traverseInOrder(innerConsumer, 0);
        } else if (mode == BinaryTraversalMode.PRE_ORDER) {
            traversePreOrder(innerConsumer, 0);
        } else if (mode == BinaryTraversalMode.POST_ORDER) {
            traversePostOrder(innerConsumer, 0);
        }
        throw new IllegalArgumentException(String.format("Traversal mode %s is not implemented!", mode));
    }

    @Override
    public int size() {
        return tree.size();
    }

    private void traverseInOrder(IBinaryTreeTraversalConsumer consumer, int i) {
        if(i == -1) {
            return;
        }
        traverseInOrder(consumer, getLeftIndex(i));
        consumer.accept(tree, i);
        traverseInOrder(consumer, getRightIndex(i));
    }

    private void traversePreOrder(IBinaryTreeTraversalConsumer consumer, int i) {
        if(i == -1) {
            return;
        }
        consumer.accept(tree, i);
        traverseInOrder(consumer, getLeftIndex(i));
        traverseInOrder(consumer, getRightIndex(i));
    }

    private void traversePostOrder(IBinaryTreeTraversalConsumer consumer, int i) {
        if(i == -1) {
            return;
        }
        traverseInOrder(consumer, getLeftIndex(i));
        traverseInOrder(consumer, getRightIndex(i));
        consumer.accept(tree, i);
    }

    @FunctionalInterface
    interface IBinaryTreeTraversalConsumer {
        void accept(List<Integer> tree, int i);
    }
}

