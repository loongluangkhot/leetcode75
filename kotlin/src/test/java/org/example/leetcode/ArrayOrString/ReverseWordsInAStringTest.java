package org.example.leetcode.ArrayOrString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInAStringTest {
    @ParameterizedTest
    @CsvSource(value = {
            "the sky is blue,blue is sky the",
            "   hello world  ,world hello",
            "a good   example,example good a"
    }, ignoreLeadingAndTrailingWhitespace = false)
    void shouldReverseWords(String input, String expectedOutput) {
        String output = new ReverseWordsInAString().reverseWords(input);
        assertEquals(expectedOutput, output);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "   hello      world      ,hello world"
    }, ignoreLeadingAndTrailingWhitespace = false)
    void shouldRemoveLeadingTrailingAndDupSpaces(String input, String expectedOutput) {
        String output = String.valueOf(new ReverseWordsInAString().removeSpaces(input));
        assertEquals(expectedOutput, output);
    }
}