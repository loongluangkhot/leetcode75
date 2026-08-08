package org.example.leetcode.DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        var result = 0;
        if(n < 3) {
            return n == 0 ? 0 : 1;
        }

        var cache = new LinkedList<>(List.of(0, 1, 1));
        for(int i = 3; i <= n; i++) {
            result = tribonacci(i, cache);
        }
        return result;
    }

    private int tribonacci(int n, LinkedList<Integer> cache) {
        var result = cache.stream().mapToInt(Integer::intValue).sum();
        cache.removeFirst();
        cache.add(result);
        return result;
    }
}
