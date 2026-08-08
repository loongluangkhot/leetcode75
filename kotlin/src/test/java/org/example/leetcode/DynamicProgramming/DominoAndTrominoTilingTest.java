package org.example.leetcode.DynamicProgramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DominoAndTrominoTilingTest {

    @ParameterizedTest
    @CsvSource({
            "3,5",
            "1,1"
    })
    public void shouldReturnNumberOfPossibleTilingsGivenWidth(int n, int expectedResult) {
        var result = new DominoAndTrominoTiling().numTilings(n);
        assertEquals(expectedResult, result);
    }
}