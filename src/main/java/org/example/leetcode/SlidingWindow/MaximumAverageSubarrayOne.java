package org.example.leetcode.SlidingWindow;

public class MaximumAverageSubarrayOne {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int currSum = 0;
        while(j < k) {
            currSum += nums[j];
            j++;
        }
        int maxSum = currSum;
        while(j < nums.length) {
            currSum = currSum + nums[j] - nums[i];
            maxSum = Math.max(maxSum, currSum);
            i++;
            j++;
        }
        return (double) maxSum / k;
    }
}
