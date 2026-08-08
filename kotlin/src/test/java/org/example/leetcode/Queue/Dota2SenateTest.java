package org.example.leetcode.Queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Dota2SenateTest {
    @ParameterizedTest
    @CsvSource({
            "DDRRR,Dire"
    })
    public void shouldReturnTheRightWinner(String senate, String expectedOutput) {
        String output = new Dota2Senate().predictPartyVictory(senate);
        assertEquals(expectedOutput, output);
    }

}