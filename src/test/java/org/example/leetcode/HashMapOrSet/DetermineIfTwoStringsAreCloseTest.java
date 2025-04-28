package org.example.leetcode.HashMapOrSet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DetermineIfTwoStringsAreCloseTest {
    @ParameterizedTest
    @CsvSource({
            "abc,bca,true",
            "a,aa,false",
            "cabbba,abcccb,true",
            "abc,adc,false"
    })
    public void shouldReturnTrueIfStringsAreClose(String a, String b, boolean expectedOutput) {
        boolean output = new DetermineIfTwoStringsAreClose().closeStrings(a, b);
        assertEquals(expectedOutput, output);
    }
}
