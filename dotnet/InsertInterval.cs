#!/usr/bin/env dotnet
// https://leetcode.com/problems/insert-interval/description/
#:include utils/ConsoleUtil.cs

var s = new Solution();

//Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
s.Insert([[1,3],[6,9]], [2,5]).PrintJaggedArr();

// Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// startInsertionIndex = 2, endInsertionIndex = 3
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
s.Insert([[1,2],[3,5],[6,7],[8,10],[12,16]], [4,8]).PrintJaggedArr();

s.Insert([[1,5]], [2,3]).PrintJaggedArr(); // [[1,5]]

s.Insert([[1,5]], [0,3]).PrintJaggedArr(); // [[0,5]]

// Binary search
public class Solution
{
    public int[][] Insert(int[][] intervals, int[] newInterval)
    {
        var result = new List<int[]>();
        var startInsertionIndex = BinarySearchInsertionIndex(intervals, newInterval[0]);
        
        var i = 0;
        while (i < startInsertionIndex)
        {
            result.Add(intervals[i]);
            i++;
        }

        var prevInterval = result.LastOrDefault();
        if (prevInterval != null && prevInterval[1] >= newInterval[0])
        {
            prevInterval[1] = Math.Max(prevInterval[1], newInterval[1]);
        } 
        else
        {
            result.Add(newInterval);
            prevInterval = newInterval;
        }

        while (i < intervals.Length)
        {
            var currInterval = intervals[i];
            if (prevInterval[1] >= currInterval[0])
            {
                prevInterval[1] = Math.Max(prevInterval[1], currInterval[1]);
            }
            else
            {
                result.Add(currInterval);
            }
            i++;
        }

        return [.. result];
    }

    // Return first index that is >= searchTarget
    // Invariant: [i, j) - Before i is < searchTarget, j or after is >= searchTarget
    private int BinarySearchInsertionIndex(int[][] intervals, int searchTarget)
    {
        var i = 0;
        var j = intervals.Length;

        while (i < j)
        {
            var mid = i + (j - i) / 2;
            var midVal = intervals[mid][0];
            if (midVal < searchTarget) i = mid + 1;
            else j = mid;
        }

        return i;
    }
}