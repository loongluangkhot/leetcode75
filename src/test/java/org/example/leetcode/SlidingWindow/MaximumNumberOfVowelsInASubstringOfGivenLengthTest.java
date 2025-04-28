package org.example.leetcode.SlidingWindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfVowelsInASubstringOfGivenLengthTest {
    @ParameterizedTest
    @CsvSource({
            "abciiidef, 3, 3",
            "aeiou, 2, 2",
            "leetcode, 3, 2"
    })
    public void shouldReturnMaxNumberOfVowels(String s, int len, int expectedOutput) {
        int output = new MaximumNumberOfVowelsInASubstringOfGivenLength().maxVowels(s, len);
        assertEquals(expectedOutput, output);
    }

}