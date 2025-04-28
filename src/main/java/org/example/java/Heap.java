package org.example.java;

import java.util.function.BiFunction;

public class Heap extends BinaryTree {
    private final HeapMode _heapMode;
    private final BiFunction<Integer, Integer, Boolean> _shouldSwap;

    public Heap(HeapMode heapMode) {
        super();
        _heapMode = heapMode;
        _shouldSwap = getShouldSwap(heapMode);
    }

    public Heap(HeapMode heapMode, int[] tree) {
        super();
        _heapMode = heapMode;
        _shouldSwap = getShouldSwap(heapMode);
        for (var num : tree) {
            add(num);
        }
    }

    private BiFunction<Integer, Integer, Boolean> getShouldSwap(HeapMode mode) {
        if (mode == HeapMode.MIN_HEAP) {
            return (childIndex, parentIndex) -> {
                var childVal = tree.get(childIndex);
                var parentVal = tree.get(parentIndex);
                return childVal < parentVal;
            };
        } else if (mode == HeapMode.MAX_HEAP) {
            return (childIndex, parentIndex) -> {
                var childVal = tree.get(childIndex);
                var parentVal = tree.get(parentIndex);
                return childVal > parentVal;
            };
        } else {
            throw new IllegalArgumentException(String.format("Heap mode %s is not implemented!", mode));
        }
    }

    @Override
    public void add(int n) {
        super.add(n);
        var i = tree.size() - 1;
        var parentIndex = getParentIndex(i);
        while (parentIndex >= 0 && _shouldSwap.apply(i, parentIndex)) {
            swap(i, parentIndex);
            i = parentIndex;
            parentIndex = getParentIndex(i);
        }
    }

    @Override
    public int remove() {
        swap(0, tree.size() - 1);
        var result = super.remove();
        var i = 0;

        var hasSwap = true;
        while (hasSwap) {
            hasSwap = false;
            var leftIndex = getLeftIndex(i);
            var rightIndex = getRightIndex(i);
            if (leftIndex >= 0 && _shouldSwap.apply(leftIndex, i)) {
                hasSwap = true;
                var swapIndex = rightIndex >= 0
                        && _shouldSwap.apply(rightIndex, i)
                        && _shouldSwap.apply(rightIndex, leftIndex)
                        ? rightIndex : leftIndex;
                swap(swapIndex, i);
                i = swapIndex;
            } else if (rightIndex >= 0 && _shouldSwap.apply(rightIndex, i)) {
                hasSwap = true;
                swap(rightIndex, i);
                i = rightIndex;
            }
        }
        return result;
    }

    public int peek() {
        return tree.isEmpty() ? -1 : tree.getFirst();
    }

    public int poll() {
        return remove();
    }

    private void swap(int i, int j) {
        var temp = tree.get(i);
        tree.set(i, tree.get(j));
        tree.set(j, temp);
    }
}
