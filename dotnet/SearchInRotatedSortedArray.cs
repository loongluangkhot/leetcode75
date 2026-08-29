#!/usr/bin/env dotnet
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

var s = new Solution();
Console.WriteLine(s.Search([0], 0));
Console.WriteLine(s.Search([0], 1));
Console.WriteLine(s.Search([0, 1], 0));
Console.WriteLine(s.Search([0, 1], 2));
Console.WriteLine(s.Search([1, 0], 0));
Console.WriteLine(s.Search([1, 0], 2));
Console.WriteLine(s.Search([4, 5, 6, 7, 0, 1, 2, 3], 0));

public class Solution
{
    public int Search(int[] nums, int target)
    {
        var i = 0;
        var j = nums.Length - 1;

        if (nums[i] <= nums[j])
        {
            // No pre-rotation
            return BinarySearch(nums, i, j + 1, target);
        }

        while (j - i > 1)
        {
            var mid = i + (j + 1 - i) / 2;
            if (nums[mid] < nums[i])
            {
                // boundary on left
                j = mid;
            }
            else
            {
                // boundary on right
                i = mid;
            }
        }

        if (target >= nums[0])
        {
            return BinarySearch(nums, 0, j, target);
        }
        else
        {
            return BinarySearch(nums, j, nums.Length, target);
        }
    }

    public int BinarySearch(int[] nums, int iIncl, int jExcl, int target)
    {
        var (i, j) = (iIncl, jExcl);
        while (i < j)
        {
            var mid = i + (j - i) / 2;
            if (target > nums[mid])
            {
                i = mid + 1;
            }
            else
            {
                j = mid;
            }
        }

        return i < nums.Length && nums[i] == target ? i : -1;
    }
}

// Approach: Search on sorted side
// public class Solution {
//     public int Search(int[] nums, int target) {
//         var i = 0;
//         var j = nums.Length - 1;

//         while (i <= j)
//         {
//             var mid = i + (j - i) / 2;
//             if (nums[mid] == target) return mid;

//             if (nums[i] <= nums[mid])
//             {
//                 // left half [i, mid] is sorted
//                 if (nums[i] <= target && target < nums[mid])
//                     j = mid - 1;
//                 else
//                     i = mid + 1;
//             }
//             else
//             {
//                 // right half [mid, j] is sorted
//                 if (nums[mid] < target && target <= nums[j])
//                     i = mid + 1;
//                 else
//                     j = mid - 1;
//             }
//         }

//         return -1;
//     }
// }
