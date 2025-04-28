package org.example.leetcode.Backtracking;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfAPhoneNumberTest {

    @Test
    public void shouldReturnAllLetterCombinationsGivenDigitsPressed() {
        var digits = "23";

        var result = (new LetterCombinationsOfAPhoneNumber()).letterCombinations(digits);

        var expectedResult = Stream.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf").collect(Collectors.toSet());
        assertEquals(expectedResult, new HashSet<>(result));
    }

}