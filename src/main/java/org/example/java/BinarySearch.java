package org.example.java;

public class BinarySearch {
    public int find(int[] nums, int target) {
        return find(nums, 0, nums.length, target);
    }

    private int find(int[] nums, int start, int end, int target) {
        if(start >= end) {
            return -1;
        }
        int mid = ((end - start) / 2) + start;
        int midValue = nums[mid];
        if(target == midValue) {
            return mid;
        } else if(target < midValue) {
            return find(nums, start, mid, target);
        } else {
            return find(nums, mid + 1, end, target);
        }
    }
}
