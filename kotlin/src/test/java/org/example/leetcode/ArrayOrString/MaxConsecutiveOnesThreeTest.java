package org.example.leetcode.ArrayOrString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MaxConsecutiveOnesThreeTest {
    public static Object[][] getTestData() {
        return new Object[][] {
                new Object[] {new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2, 6},
                new Object[] {new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3, 10},
                new Object[] {new int[] {1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1}, 8, 25},
        };
    }
    @ParameterizedTest
    @MethodSource("getTestData")
    public void shouldReturnMaxConsecutiveOnes(int[] nums, int k, int expectedResult) {
        var result = new MaxConsecutiveOnesThree().longestOnes(nums, k);
        assertEquals(expectedResult, result);
    }

}