package org.example.leetcode.Graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NearestExitFromEntranceInMazeTest {

    public static List<Object[]> testCases() {
        Object[] case1 = new Object[]{
                new char[][]{
                        {'+', '+', '.', '+'},
                        {'.', '.', '.', '+'},
                        {'+', '+', '+', '.'}
                },
                new int[]{1, 2},
                1
        };

        Object[] case2 = new Object[]{
                new char[][]{
                        {'+', '+', '+'},
                        {'.', '.', '.'},
                        {'+', '+', '+'}
                },
                new int[]{1, 0},
                2
        };

        Object[] case3 = new Object[]{
                new char[][]{
                        {'.'},
                        {'.'}
                },
                new int[]{1, 0},
                1
        };
        return Arrays.asList(case1, case2, case3);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void shouldReturnNearestExistFromEntrance(char[][] maze, int[] entrance, int expectedOutput) {
        NearestExitFromEntranceInMaze svc = new NearestExitFromEntranceInMaze();
        int output = svc.nearestExit(maze, entrance);

        assertEquals(expectedOutput, output);
    }

}