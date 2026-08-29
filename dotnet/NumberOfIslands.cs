#!/usr/bin/env dotnet
// https://leetcode.com/problems/number-of-islands/description/

public class Solution
{
    public int NumIslands(char[][] grid)
    {
        var height = grid.Length;
        var width = grid[0].Length;

        var visited = new bool[height][];
        for (var i = 0; i < height; i++)
        {
            visited[i] = new bool[width];
        }

        void Dfs(int row, int col)
        {
            visited[row][col] = true;
            if (grid[row][col] == '0')
            {
                return;
            }

            // top
            if (row - 1 >= 0 && !visited[row - 1][col])
            {
                Dfs(row - 1, col);
            }

            // btm
            if (row + 1 < height && !visited[row + 1][col])
            {
                Dfs(row + 1, col);
            }

            // left
            if (col - 1 >= 0 && !visited[row][col - 1])
            {
                Dfs(row, col - 1);
            }

            // right
            if (col + 1 < width && !visited[row][col + 1])
            {
                Dfs(row, col + 1);
            }
        }

        var count = 0;

        for (var i = 0; i < height; i++)
        {
            for (var j = 0; j < width; j++)
            {
                if (grid[i][j] == '1' && !visited[i][j])
                {
                    Dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
