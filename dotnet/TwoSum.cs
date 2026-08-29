#!/usr/bin/env dotnet
// https://leetcode.com/problems/two-sum/description/

var s = new Solution();

// Console.WriteLine(string.Join(",", s.TwoSum([2, 7, 11, 15], 9)));
Console.WriteLine(string.Join(",", s.TwoSum([3, 3], 6)));

public class Solution
{
    // // Two pointers O(nlogn)
    // public int[] TwoSum(int[] nums, int target) {

    //     var sortedList = nums.Select((val, index) => (val, index))
    //         .OrderBy(p => p.val)
    //         .ToArray();
    //     var i = 0;
    //     var j = nums.Length - 1;
    //     while (i < j) {
    //         var (leftVal, leftIndex) = sortedList[i];
    //         var (rightVal, rightIndex) = sortedList[j];
    //         var sum = leftVal + rightVal;
    //         if (sum == target) {
    //             return [leftIndex, rightIndex];
    //         } else if (sum < target) {
    //             i++;
    //         } else {
    //             j--;
    //         }
    //     }
    //     throw new Exception("No solution");
    // }

    // // Hashmap O(n)
    // public int[] TwoSum(int[] nums, int target)
    // {
    //     var valToIndexListMap = new Dictionary<int, List<int>>();
    //     for (var i = 0; i < nums.Length; i++)
    //     {
    //         var val = nums[i];
    //         if (valToIndexListMap.ContainsKey(val))
    //         {
    //             valToIndexListMap[val].Add(i);
    //         }
    //         else
    //         {
    //             valToIndexListMap[val] = new List<int> { i };
    //         }
    //     }

    //     for (var i = 0; i < nums.Length; i++)
    //     {
    //         var val = nums[i];
    //         var remainder = target - val;
    //         if (valToIndexListMap.TryGetValue(remainder, out List<int>? remainderIndexList))
    //         {
    //             var remainderIndex = remainderIndexList
    //                 .Cast<int?>()
    //                 .FirstOrDefault(j => j != i, null);
    //             if (remainderIndex != null)
    //             {
    //                 return [i, remainderIndex.Value];
    //             }
    //         }
    //     }

    //     throw new Exception("No solution");
    // }

    // Hashmap O(n)
    public int[] TwoSum(int[] nums, int target)
    {
        var valToIndexMap = new Dictionary<int, int>();
        for (var i = 0; i < nums.Length; i++)
        {
            var val = nums[i];
            var complement = target - val;

            if (valToIndexMap.TryGetValue(complement, out int complementIndex))
            {
                return [i, complementIndex];
            }

            valToIndexMap[val] = i;
        }

        throw new Exception("No solution");
    }
}
