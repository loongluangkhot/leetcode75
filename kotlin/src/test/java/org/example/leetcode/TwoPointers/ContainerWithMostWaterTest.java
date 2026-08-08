package org.example.leetcode.TwoPointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerWithMostWaterTest {
    public static Stream<Object[]> testData() {
        return Stream.of(
                new Object[]{new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49},
                new Object[]{new int[]{1, 1}, 1}
                );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void shouldReturnMaxArea(int[] input, int expectedOutput) {
        int output = new ContainerWithMostWater().maxArea(input);
        assertEquals(expectedOutput, output);
    }
}
