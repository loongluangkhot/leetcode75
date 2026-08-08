package org.example.leetcode.PrefixSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindPivotIndexTest {
    public static Stream<Object[]> testData() {
        return Stream.of(
                new Object[] {new int[] {1,7,3,6,5,6}, 3},
                new Object[] {new int[] {1,2,3}, -1},
                new Object[] {new int[] {2,1,-1}, 0}
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void shouldReturnPivotIndex(int[] nums, int expectedOutput) {
        int output = new FindPivotIndex().pivotIndex(nums);
        assertEquals(expectedOutput, output);
    }
}