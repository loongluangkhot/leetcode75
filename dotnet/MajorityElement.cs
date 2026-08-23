#!/usr/bin/env dotnet
// https://leetcode.com/problems/majority-element/description/

var s = new Solution();
Console.WriteLine(s.MajorityElement([3,2,3])); // 3
Console.WriteLine(s.MajorityElement([2,2,1,1,1,2,2])); // 2

public class Solution {

    // Boyer-Moore majority voting algorithm
    public int? MajorityElement(int[] nums) {
        var candidate = 0;
        var count = 0;

        foreach (var val in nums)
        {
            if (count == 0)
            {
                candidate = val;
                count++;
            }
            else if (candidate == val)
            {
                count++;
            } 
            else
            {
                count--;
            }
        }

        return nums.Count(i => i == candidate) > nums.Length / 2  ? candidate : null;
    }
}