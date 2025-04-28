package org.example.leetcode.ArrayOrString;

public class MaxConsecutiveOnesThree {
//    public int longestOnes(int[] nums, int k) {
//        int remainingFlip = k;
//        int currCnt = 0;
//        int maxCnt = 0;
//        int i = 0;
//        int j = 0;
//
//        while (j < nums.length) {
//            if (nums[j] == 1) {
//                currCnt++;
//            } else if (nums[j] == 0) {
//                if (remainingFlip > 0) {
//                    // Have flips left
//                    remainingFlip--;
//                    currCnt++;
//                } else {
//                    while(nums[i] == 1) {
//                        i++;
//                        currCnt--;
//                    }
//                    i++;
//                }
//            }
//            j++;
//            maxCnt = Math.max(maxCnt, currCnt);
//        }
//
//        return maxCnt;
//    }

    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if(nums[j] == 0) {
                k--;
            }
            if(k < 0) {
                if(nums[i] == 0) {
                    k++;
                }
                i++;
            }

            j++;
        }
        return j - i;
    }
}