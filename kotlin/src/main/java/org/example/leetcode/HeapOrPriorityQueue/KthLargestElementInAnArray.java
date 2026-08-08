package org.example.leetcode.HeapOrPriorityQueue;

import org.example.java.Heap;
import org.example.java.HeapMode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// https://leetcode.com/problems/kth-largest-element-in-an-array
public class KthLargestElementInAnArray {
    // Attempt 1
//    public int findKthLargest(int[] nums, int k) {
//        Heap maxHeap = new Heap(Heap::MinHeapMode);
//        for (int num : nums) {
//            maxHeap.add(num);
//            if(maxHeap.size() > k) {
//                maxHeap.pop();
//            }
//        }
//
//        return maxHeap.peek();
//    }
//
//    public class Heap {
//        List<Integer> nodes = new ArrayList<>();
//        BiFunction<Integer, Integer, Boolean> shouldSwap;
//
//        public static boolean MinHeapMode(int parent, int child) {
//            return parent > child;
//        }
//        public static boolean MaxHeapMode(int parent, int child) {
//            return parent < child;
//        }
//
//        public Heap(BiFunction<Integer, Integer, Boolean> mode) {
//            shouldSwap = mode;
//        }
//
//        private int getParent(int i) {
//            return (i - 1) / 2;
//        }
//
//        private int getLeft(int i) {
//            return getRight(i) - 1;
//        }
//
//        private int getRight(int i) {
//            return (i + 1) * 2;
//        }
//
//        private void swap(int i, int j) {
//            int temp = nodes.get(i);
//            nodes.set(i, nodes.get(j));
//            nodes.set(j, temp);
//        }
//
//        public void add(int val) {
//            nodes.add(val);
//            int lastIndex = nodes.size() - 1;
//            int parentIndex = getParent(lastIndex);
//            while (lastIndex != 0) {
//                if(shouldSwap.apply(nodes.get(parentIndex), nodes.get(lastIndex))) {
//                    swap(lastIndex, parentIndex);
//                }
//                lastIndex = parentIndex;
//                parentIndex = getParent(lastIndex);
//            }
//        }
//
//        public int pop() {
//            int maxVal = nodes.get(0);
//            int lastNodeVal = nodes.remove(nodes.size() - 1);
//            if(!nodes.isEmpty()) {
//                nodes.set(0, lastNodeVal);
//                heapify();
//            }
//            return maxVal;
//        }
//
//        public int peek() {
//            return nodes.get(0);
//        }
//
//        public int size() {
//            return nodes.size();
//        }
//
//        private void heapify() {
//            int parentIndex = 0;
//            int size = nodes.size();
//            boolean swapped = true;
//            while(swapped) {
//                swapped = false;
//                int leftIndex = getLeft(parentIndex);
//                int rightIndex = getRight(parentIndex);
//                if (leftIndex < size) {
//                    int swapIndex = leftIndex;
//                    if (rightIndex < size && shouldSwap.apply(nodes.get(leftIndex), nodes.get(rightIndex))) {
//                        swapIndex = rightIndex;
//                    }
//                    if(shouldSwap.apply(nodes.get(parentIndex), nodes.get(swapIndex))) {
//                        swap(swapIndex, parentIndex);
//                        swapped = true;
//                        parentIndex = swapIndex;
//                    }
//                }
//            }
//
//        }
//    }

//    // Attempt 2
//    public int findKthLargest(int[] nums, int k) {
//        var q = new PriorityQueue<Integer>(Comparator.reverseOrder());
//        for (var num : nums) {
//            q.add(num);
//        }
//        Integer result = null;
//        while(k > 0) {
//            result = q.poll();
//            k--;
//        }
//        return result;
//    }

//    // Attempt 3
//    public int findKthLargest(int[] nums, int k) {
//        var q = new PriorityQueue<Integer>(Comparator.reverseOrder());
//        for (var num : nums) {
//            q.add(num);
//            if (q.size() > nums.length - k + 1) {
//                q.poll();
//            }
//        }
//        return q.peek();
//    }

    // Attempt 4: Use built-in priority queue
//    public int findKthLargest(int[] nums, int k) {
//        var heap = new PriorityQueue<Integer>();
//        for (var num : nums) {
//            heap.add(num);
//            if (heap.size() > k) {
//                heap.poll();
//            }
//        }
//        return heap.peek();
//    }

    // Attempt 5: Use self-implemented heap
    public int findKthLargest(int[] nums, int k) {
        var heap = new Heap(HeapMode.MIN_HEAP);
        for (var num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
