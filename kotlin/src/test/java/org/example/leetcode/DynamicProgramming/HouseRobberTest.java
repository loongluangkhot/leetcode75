package org.example.leetcode.DynamicProgramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    public static Stream<Object[]> testData() {
        return Stream.of(
                new Object[]{new int[]{1, 2, 3, 1}, 4},
                new Object[]{new int[]{2, 7, 9, 3, 1}, 12},
                new Object[]{new int[]{2, 1, 1, 2}, 4},
                new Object[]{new int[]{3, 2, 1, 9, 3, 4, 8, 2}, 20}
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void shouldReturnMaxRobbedAmount(int[] nums, int expectedResult) {
        var result = new HouseRobber().rob(nums);

        assertEquals(expectedResult, result);
    }

}