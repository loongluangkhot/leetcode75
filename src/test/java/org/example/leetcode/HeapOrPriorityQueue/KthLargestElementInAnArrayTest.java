package org.example.leetcode.HeapOrPriorityQueue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInAnArrayTest {

    public static Object[][] getTestData() {
        return new Object[][] {
                new Object[] {new int[] {3,2,1,5,6,4}, 2, 5},
                new Object[] {new int[] {3,2,3,1,2,4,5,5,6}, 2, 5},
        };
    }
    @ParameterizedTest
    @MethodSource("getTestData")
    public void shouldReturnKthLargestElementInGivenArray(int[] nums, int k, int expectedResult) {
        var result = new KthLargestElementInAnArray().findKthLargest(nums, k);

        assertEquals(expectedResult, result);
    }

}