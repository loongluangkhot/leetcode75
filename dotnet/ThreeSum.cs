#!/usr/bin/env dotnet
// https://leetcode.com/problems/3sum/description/

#:include utils/ConsoleUtil.cs

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
var s = new Solution();
s.ThreeSum([-1,0,1,2,-1,-4]).PrintJaggedArr();

public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        var result = new List<IList<int>>();
        var sorted = nums.Order().ToArray();

        for (var i = 0; i < sorted.Length - 2; i++)
        {
            var first = sorted[i];
            if ((i > 0 && sorted[i] == sorted[i - 1]) || first > 0) continue;
            var j = i + 1;
            var k = sorted.Length - 1;
            while (j < k)
            {
                var searchTarget = -first;
                var second = sorted[j];
                var third = sorted[k];
                var sum = second + third;
                if (sum < searchTarget)
                {
                    j++;
                }
                else if (sum > searchTarget)
                {
                    k--;
                }
                else
                {
                    result.Add(new List<int> { first, second, third });
                    j++; k--;
                    while (j < k && sorted[j] == sorted[j - 1]) j++; // skip dup second
                    while (j < k && sorted[k] == sorted[k + 1]) k--; // skip dup third
                }
            }
        }
        return result;
    }
}