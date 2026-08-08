package org.example.leetcode.Intervals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingIntervalsTest {

    public static Object[][] getTestData() {
        return new Object[][]{
                new Object[]{
                        "[[1,2],[2,3],[3,4],[1,3]]",
                        1
                },
                new Object[]{
                        "[[1,2],[1,2],[1,2]]",
                        2
                },
                new Object[]{
                        "[[1,2],[2,3]]",
                        0
                },
                new Object[]{
                        "[[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]",
                        7
                },
        };
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    public void shouldReturnMinNumOfIntervalsToRemoveToGetNonOverlappingIntervals(String intervalsString, int expectedResult) throws JsonProcessingException {
        var intervals = new ObjectMapper().readValue(intervalsString, int[][].class);
        var result = new NonOverlappingIntervals().eraseOverlapIntervals(intervals);
        assertEquals(expectedResult, result);
    }

}