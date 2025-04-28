package org.example.leetcode.TwoPointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {
    static Stream<Object[]> testParameters() {
        return Stream.of(
                new Object[]{new int[]{1, 0, 3, 0, 5}, new int[]{1, 3, 5, 0, 0}},
                new Object[]{new int[]{0}, new int[]{0}}
        );
    }
    @ParameterizedTest
    @MethodSource("testParameters")
    public void shouldMoveZerosToTheBack(int[] input, int[] expectedOutput) {
        new MoveZeroes().moveZeroes(input);
        assertArrayEquals(input, expectedOutput);
    }
}