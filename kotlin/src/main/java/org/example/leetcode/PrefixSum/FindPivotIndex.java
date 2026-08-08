package org.example.leetcode.PrefixSum;

public class FindPivotIndex {
//    // Solution 1
//    public int pivotIndex(int[] nums) {
//        int[] prefixSum = new int[nums.length];
//        prefixSum[0] = 0;
//        for(int i = 1; i < nums.length; i++) {
//            prefixSum[i] = nums[i-1] + prefixSum[i-1];
//        }
//        int[] suffixSum = new int[nums.length];
//        suffixSum[suffixSum.length - 1] = 0;
//        for(int i = suffixSum.length - 2; i >= 0; i--) {
//            suffixSum[i] = suffixSum[i+1] + nums[i+1];
//        }
//        for(int i = 0; i < nums.length; i++) {
//            if(prefixSum[i] == suffixSum[i]) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }

            leftsum += nums[i];
        }
        return -1;
    }
}
