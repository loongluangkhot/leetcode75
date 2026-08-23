#!/usr/bin/env dotnet
// https://leetcode.com/problems/maximum-subarray/description/

var s = new Solution();
Console.WriteLine(s.MaxSubArray([-2,1,-3,4,-1,2,1,-5,4]));

// // Prefix sum approach
// // prefix[i] = nums[0] + ... + nums[i]
// // n[l..r] = prefix[r] - prefix[l-1]
// public class Solution {
//     public int MaxSubArray(int[] nums)
//     {
        
//         var max = int.MinValue;
//         var currPrefix = 0;
//         var minPrefix = 0;
//         foreach (var n in nums)
//         {
//             currPrefix += n;
//             max = Math.Max(max, currPrefix - minPrefix);
//             minPrefix = Math.Min(minPrefix, currPrefix);
//         }
//         return max;
//     }
// }

// Kadane's algorithm
// MaxSubArray ending at i = best[i] = Math.Max(best[i - 1] + n[i], n[i]) -- either EXTEND or RESTART

public class Solution {
    public int MaxSubArray(int[] nums)
    {
        var max = int.MinValue;
        var prevMax = Math.Min(nums[0], 0);
        foreach (var n in nums)
        {
            var currMax = Math.Max(prevMax + n, n);
            prevMax = currMax;
            max = Math.Max(max, currMax);
        }
        return max;
    }
}