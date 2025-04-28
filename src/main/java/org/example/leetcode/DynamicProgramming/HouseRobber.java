package org.example.leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {
//    // Approach 1: Brute force
//    public int rob(int[] nums) {
//        if(nums.length == 0) {
//            return 0;
//        } else if (nums.length == 1) {
//            return nums[0];
//        }
//        return Math.max(checkMax(0, 0, nums), checkMax(1, 0, nums));
//    }
//
//    public int checkMax(int index, int currSum, int[] nums) {
//        if(index >= nums.length) {
//            return currSum;
//        }
//        currSum += nums[index];
//        return Math.max(checkMax(index + 2, currSum, nums), checkMax(index + 3, currSum, nums));
//    }

//    // Approach 2: DP - top down
//    public int rob(int[] nums) {
//        if(nums.length == 0) {
//            return 0;
//        } else if (nums.length == 1) {
//            return nums[0];
//        }
//        var cache = new int[nums.length];
//        Arrays.fill(cache, -1);
//
//        return robFrom(0, nums, cache);
//
//    }
//
//    public int robFrom(int i, int[] nums, int[] cache) {
//        if(i >= nums.length) {
//            return 0;
//        }
//
//        if(cache[i] != -1) {
//            return cache[i];
//        }
//
//        var option1 = robFrom(i + 1, nums, cache);
//        var option2 = robFrom(i + 2, nums, cache) + nums[i];
//        var result = Math.max(option1, option2);
//
//        cache[i] = result;
//        return result;
//    }

    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        var n2 = 0;
        var n1 = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            var n0 = Math.max(n1, n2 + nums[i]);
            n2 = n1;
            n1 = n0;
        }
        return n1;
    }


}
// [3,1,3]
// [2,9]

// [3,2,1,9,3,4,8,2] 3 + 9 + 7
// [1,0,0,1,0,0,1,0]
// [3,2,1,9,3,4,5,2]
// [1,0,0,1,0,1,0,1]

// [1,2,3,9,3,4,7,2]