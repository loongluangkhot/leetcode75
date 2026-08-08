package org.example.leetcode.Stack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {
    public static Object[][] getTestData() {
        return new Object[][]{
                new Object[]{"[73,74,75,71,69,72,76,73]", "[1,1,4,2,1,1,0,0]"},
                new Object[]{"[30,40,50,60]", "[1,1,1,0]"},
                new Object[]{"[30,60,90]", "[1,1,0]"}
        };
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    public void shouldReturnNumOfDaysBeforeHigherTempIsObserved(String inputStr, String expectedOutputStr) throws JsonProcessingException {
        var input = new ObjectMapper().readValue(inputStr, int[].class);
        var expectedOutput = new ObjectMapper().readValue(expectedOutputStr, int[].class);
        var result = new DailyTemperatures().dailyTemperatures(input);
        assertArrayEquals(expectedOutput, result);
    }
}