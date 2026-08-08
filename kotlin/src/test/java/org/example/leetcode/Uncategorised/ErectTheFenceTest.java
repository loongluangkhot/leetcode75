package org.example.leetcode.Uncategorised;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ErectTheFenceTest {

    public static Object[][] getTestData() {
        return new Object[][]{
                new Object[]{"[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]", "[[1,1],[2,0],[4,2],[3,3],[2,4]]"},
                new Object[]{"[[1,2],[2,2],[4,2]]", "[[4,2],[2,2],[1,2]]"}
        };
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    public void shouldReturnTreeCoordsAtPerimeter(String inputStr, String expectedOutputStr) throws JsonProcessingException {
        var input = new ObjectMapper().readValue(inputStr, int[][].class);
        var expectedOutput = new ObjectMapper().readValue(expectedOutputStr, int[][].class);
        var output = new ErectTheFence().outerTrees(input);

        assertEquals(expectedOutput.length, output.length);
        for(var arr : expectedOutput) {
            assertTrue(
                    Arrays.stream(output).anyMatch(j -> Arrays.equals(j, arr)),
                    String.format("Expected %s to be in %s", Arrays.toString(arr), Arrays.deepToString(output))
            );
        }
    }
}