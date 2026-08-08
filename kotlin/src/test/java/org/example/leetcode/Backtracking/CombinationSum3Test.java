package org.example.leetcode.Backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSum3Test {
    @Test
    public void shouldReturnCombinationOfKNumbersThatSumUpToN() {
        var k = 3;
        var n = 7;

        var results = new CombinationSum3().combinationSum3(k, n);

        assertEquals(1, results.size());
        assertIterableEquals(List.of(1, 2, 4), results.getFirst());
    }

}