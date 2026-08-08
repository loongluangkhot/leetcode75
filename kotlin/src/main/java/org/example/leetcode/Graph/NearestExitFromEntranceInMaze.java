package org.example.leetcode.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int height = maze.length;
        int width = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[height*width];
        addToQueueAndMarkVisited(q, visited, new int[] {entrance[0], entrance[1], 0}, width);

        while(!q.isEmpty()) {
            int[] pos = q.remove();
            List<int[]> neighbours = getUntouchedNeighbours(maze, pos, visited, height, width);
            for(int[] n : neighbours) {
                if(isExit(n, height, width)) {
                    return n[2];
                }
                addToQueueAndMarkVisited(q, visited, n, width);
            }
        }

        return -1;
    }

    private boolean isExit(int[] pos, int height, int width) {
        int x = pos[0];
        int y = pos[1];
        return x == 0 || y == 0 || x == height-1 || y == width-1;
    }

    private List<int[]> getUntouchedNeighbours(char[][] maze, int[] pos, boolean[] visited, int height, int width) {
        int x = pos[0];
        int y = pos[1];
        int distance = pos[2] + 1;
        List<int[]> neighbours = Arrays.asList(new int[][] {
                {x, y-1, distance},
                {x, y+1, distance},
                {x-1, y, distance},
                {x+1, y, distance}
        }).stream()
                .filter(i -> isEmptyCell(maze, i, height, width) && !isVisited(visited, i, width))
                .collect(Collectors.toList());
        return neighbours;
    }

    private boolean isVisited(boolean[] visited, int[] pos, int width) {
        int x = pos[0];
        int y = pos[1];
        return visited[x * width + y];
    }

    private void addToQueueAndMarkVisited(Queue<int[]> q, boolean[] visited, int[] pos, int width) {
        int x = pos[0];
        int y = pos[1];
        visited[x * width + y] = true;
        q.add(pos);
    }

    private boolean isEmptyCell(char[][] maze, int[] pos, int height, int width) {
        int x = pos[0];
        int y = pos[1];
        return x >= 0 && x < height && y >= 0 && y < width && maze[x][y] == '.';
    }
}
