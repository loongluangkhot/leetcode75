package org.example.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/description/?envType=study-plan-v2&envId=leetcode-75
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        var result = new int[temperatures.length];
        Arrays.fill(result, 0);
        var records = new ArrayDeque<Integer>();
        for (var i = 0; i < temperatures.length; i++) {
            while (!records.isEmpty()) {
                var record = records.pop();
                if (temperatures[i] > temperatures[record]) {
                   result[record] = i - record;
                } else {
                    records.push(record);
                    break;
                }
            }
            records.push(i);
        }
        return result;
    }
}
