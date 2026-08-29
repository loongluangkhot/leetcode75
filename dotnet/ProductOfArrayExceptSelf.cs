#!/usr/bin/env dotnet
// https://leetcode.com/problems/product-of-array-except-self/description/

#:include utils/ConsoleUtil.cs

var s = new Solution();
s.ProductExceptSelf([1, 2, 3, 4]).PrintArr(); // [24,12,8,6]
s.ProductExceptSelf([-1, 1, 0, -3, 3]).PrintArr(); // [0,0,9,0,0]

// public class Solution {
//     public int[] ProductExceptSelf(int[] nums) {

//         if (nums.Length == 0)
//         {
//             return [];
//         }
//         if (nums.Length == 1)
//         {
//             return [0];
//         }

//         var prefixProducts = new int[nums.Length];
//         var suffixProducts = new int[nums.Length];
//         var lastIndex = nums.Length - 1;
//         for (var i = 0; i < nums.Length; i++)
//         {
//             prefixProducts[i] = i == 0 ? nums[0] : prefixProducts[i - 1] * nums[i];

//             var j = lastIndex - i;
//             suffixProducts[j] = i == 0 ? nums[lastIndex] : suffixProducts[j + 1] * nums[j];
//         }

//         var result = new int[nums.Length];
//         result[0] = suffixProducts[1];
//         result[lastIndex] = prefixProducts[lastIndex - 1];
//         for (var i = 1; i < lastIndex; i++)
//         {
//             result[i] = prefixProducts[i - 1] * suffixProducts[i + 1];
//         }

//         return result;
//     }
// }

public class Solution
{
    public int[] ProductExceptSelf(int[] nums)
    {
        int[] answer = new int[nums.Length];
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < nums.Length; i++)
        {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = nums.Length - 1; i >= 0; i--)
        {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}
