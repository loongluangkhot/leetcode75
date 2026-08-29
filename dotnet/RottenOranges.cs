#!/usr/bin/env dotnet
// https://leetcode.com/problems/rotting-oranges/description/

var s = new Solution();
Console.WriteLine(
    s.OrangesRotting([
        [2, 1, 1],
        [1, 1, 0],
        [0, 1, 1],
    ])
);

public class Solution
{
    public int OrangesRotting(int[][] grid)
    {
        var height = grid.Length;
        var width = grid[0].Length;

        var q = new Queue<(int row, int col)>();
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (grid[i][j] == 2)
                {
                    q.Enqueue((i, j));
                }
            }
        }

        void GetFreshNeighboursAndMarkRotten(
            Queue<(int row, int col)> nextQueue,
            (int row, int col) rotten
        )
        {
            var (row, col) = rotten;

            // top
            if (row - 1 >= 0 && grid[row - 1][col] == 1)
            {
                grid[row - 1][col] = 2;
                nextQueue.Enqueue((row - 1, col));
            }
            // btm
            if (row + 1 < height && grid[row + 1][col] == 1)
            {
                grid[row + 1][col] = 2;
                nextQueue.Enqueue((row + 1, col));
            }
            // left
            if (col - 1 >= 0 && grid[row][col - 1] == 1)
            {
                grid[row][col - 1] = 2;
                nextQueue.Enqueue((row, col - 1));
            }
            // right
            if (col + 1 < width && grid[row][col + 1] == 1)
            {
                grid[row][col + 1] = 2;
                nextQueue.Enqueue((row, col + 1));
            }
        }

        var count = 0;
        while (q.Count > 0)
        {
            var next = new Queue<(int row, int col)>();
            while (q.Count > 0)
            {
                var rotten = q.Dequeue();
                GetFreshNeighboursAndMarkRotten(next, rotten);
            }
            if (next.Count > 0)
            {
                count++;
            }
            q = next;
        }

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (grid[i][j] == 1)
                {
                    return -1;
                }
            }
        }

        return count;
    }
}
