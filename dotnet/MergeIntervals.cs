#!/usr/bin/env dotnet
// https://leetcode.com/problems/merge-intervals/description/
#:include utils/ConsoleUtil.cs

var s = new Solution();
s.Merge([[1, 3], [2, 6], [8, 10], [15, 18]]).PrintJaggedArr(); // [[1,6],[8,10],[15,18]]
s.Merge([[1, 4], [4, 5]]).PrintJaggedArr(); // [[1,5]]
s.Merge([[1, 3]]).PrintJaggedArr(); // [[1,3]]
s.Merge([[1, 4], [2, 3]]).PrintJaggedArr(); // [[1,4]]

// public class Solution {
//     public int[][] Merge(int[][] intervals) {
//         var result = new List<int[]>();
//         if (intervals.Length <= 1)
//         {
//             return intervals;
//         }
//         intervals = intervals.OrderBy(i => i[0]).ToArray();
//         var i = 0;
//         var j = 1;
//         var currEnd = intervals[0][1];
//         while (j < intervals.Length)
//         {
//             if (intervals[j][0] > currEnd)
//             {
//                 // Not overlapping
//                 result.Add([intervals[i][0], currEnd]);
//                 i = j;
//             }
//             currEnd = Math.Max(currEnd, intervals[j][1]);
//             j++;
//         }

//         result.Add([intervals[i][0], currEnd]);

//         return result.ToArray();
//     }
// }


public class Solution
{
    public int[][] Merge(int[][] intervals)
    {
        var result = new List<int[]>();
        intervals = intervals.OrderBy(i => i[0]).ToArray();
        foreach (var i in intervals)
        {
            if (result.Count > 0 && i[0] <= result[^1][1])
            {
                result[^1][1] = Math.Max(result[^1][1], i[1]);
            }
            else
            {
                result.Add(i);
            }
        }

        return result.ToArray();
    }
}