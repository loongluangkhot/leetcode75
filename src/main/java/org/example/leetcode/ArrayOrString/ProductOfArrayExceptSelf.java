package org.example.leetcode.ArrayOrString;

// https://leetcode.com/problems/product-of-array-except-self
public class ProductOfArrayExceptSelf {

    // public int[] productExceptSelf(int[] nums) {
    //     var forwardProductArr = new int[nums.length];
    //     var backwardProductArr = new int[nums.length];
    //     forwardProductArr[0] = nums[0];
    //     backwardProductArr[nums.length - 1] = nums[nums.length - 1];

    //     for (var i = 1; i < nums.length - 1; i++) {
    //         forwardProductArr[i] = nums[i] * forwardProductArr[i-1];
    //         var j = nums.length - 1 - i;
    //         backwardProductArr[j] = nums[j] * backwardProductArr[j+1];
    //     }

    //     var answer = new int[nums.length];
    //     for (var i = 0; i < answer.length; i++) {
    //         var beforeProduct = i == 0 ? 1 : forwardProductArr[i-1];
    //         var afterProduct = i == nums.length - 1 ? 1 : backwardProductArr[i+1];
    //         answer[i] = beforeProduct * afterProduct;
    //     }

    //     return answer;
    // }

    public int[] productExceptSelf(int[] nums) {
        var answer = new int[nums.length];
        answer[nums.length - 1] = nums[nums.length - 1];

        for (var i = nums.length - 2; i >= 0; i--) {
            answer[i] = nums[i] * answer[i+1];
        }

        var beforeProduct = 1;
        for (var i = 0; i < answer.length; i++) {
            var afterProduct = i == nums.length - 1 ? 1 : answer[i+1];
            answer[i] = beforeProduct * afterProduct;
            beforeProduct *= nums[i];
        }

        return answer;
    }
}
