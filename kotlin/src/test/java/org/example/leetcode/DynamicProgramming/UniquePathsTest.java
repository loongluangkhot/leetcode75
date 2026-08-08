package org.example.leetcode.DynamicProgramming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {

    @ParameterizedTest
    @CsvSource({
            "3,2,3",
            "3,7,28"
    })
    public void shouldReturnNumOfUniquePaths(int m, int n, int expectedOutput) {
        var output = new UniquePaths().uniquePaths(m, n);
        assertEquals(expectedOutput, output);
    }


}