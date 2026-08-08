package org.example.leetcode.Intervals;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/non-overlapping-intervals
// interval scheduling problem
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        var result = 0;
        var k = Integer.MIN_VALUE;
        for (var interval : intervals) {
            if (interval[0] < k) {
                // overlap
                result++;
            } else {
                k = interval[1];
            }
        }
        return result;
    }
}
