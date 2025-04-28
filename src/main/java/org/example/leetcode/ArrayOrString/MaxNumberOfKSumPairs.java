package org.example.leetcode.ArrayOrString;

import java.util.Arrays;

// https://leetcode.com/problems/max-number-of-k-sum-pairs
public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        if(nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int result = 0;
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                result++;
                i++;
                j--;
            }
        }
        return result;
    }
}
