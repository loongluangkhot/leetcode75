package org.example.leetcode.SlidingWindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumAverageSubarrayOneTest {
    public static Stream<Object> testData() {
        return Stream.of(
                new Object[]{new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75000},
                new Object[]{new int[]{5}, 1, 5.0},
                new Object[]{new int[]{0, 4, 0, 3, 2}, 1, 4}
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void shouldFindTheMaximum(int[] nums, int k, double expectedOutput) {
        double output = new MaximumAverageSubarrayOne().findMaxAverage(nums, k);
        assertTrue(Math.abs(output - expectedOutput) < 1e-5);
    }

}