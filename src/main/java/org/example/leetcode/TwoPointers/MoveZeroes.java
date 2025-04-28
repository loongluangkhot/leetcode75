package org.example.leetcode.TwoPointers;

public class MoveZeroes {
//    // Solution 1
//    public void moveZeroes(int[] nums) {
//        int i = 0;
//        int j = 0;
//        while(i < nums.length) {
//            if(nums[i] == 0) {
//                if(j < i) {
//                    j = i;
//                }
//                while(nums[j] == 0) {
//                    j++;
//                    if(j >= nums.length) {
//                        return;
//                    }
//                }
//                swap(nums, i, j);
//            }
//            i++;
//        }
//    }

    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
