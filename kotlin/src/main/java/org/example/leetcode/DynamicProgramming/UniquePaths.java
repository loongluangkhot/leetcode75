package org.example.leetcode.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/unique-paths
public class UniquePaths {
//    public int uniquePaths(int m, int n) {
//        var result = 0;
//        var stack = new ArrayDeque<List<Integer>>();
//        stack.push(Arrays.asList(m - 1, n - 1));
//        while (!stack.isEmpty()) {
//            var i = stack.pop();
//            if (i.get(0) == 0 && i.get(1) == 0) {
//                result++;
//            } else {
//                if (i.get(0) > 0) {
//                    stack.push(Arrays.asList(i.get(0) - 1, i.get(1)));
//                }
//                if (i.get(1) > 0) {
//                    stack.push(Arrays.asList(i.get(0), i.get(1) - 1));
//                }
//            }
//        }
//        return result;
//    }

    public int uniquePaths(int m, int n) {
        var cache = new int[m][n];
        for (int[] arr : cache) {
            Arrays.fill(arr, 1);
        }
        for (var i = 1; i < cache.length; i++) {
            for (var j = 1; j < cache[i].length; j++) {
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        return cache[m - 1][n - 1];
    }
}
