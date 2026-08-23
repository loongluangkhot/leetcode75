#!/usr/bin/env dotnet
// https://leetcode.com/problems/01-matrix/description/

#:include utils/ConsoleUtil.cs

var s = new Solution();
s.UpdateMatrix([[0, 0, 0], [0, 1, 0], [1, 1, 1]]).PrintJaggedArr();

// Multi-source BFS
public class Solution
{
    public int[][] UpdateMatrix(int[][] mat)
    {
        var height = mat.Length;
        var width = mat[0].Length;
        var result = new int[height][];
        var q = new Queue<(int row, int col, int count)>();
        for (var i = 0; i < height; i++)
        {
            var row = new int[width];
            for (var j = 0; j < width; j++)
            {
                if (mat[i][j] == 0)
                {
                    q.Enqueue((i, j, 0));
                    row[j] = 0;
                }
                else
                {
                    row[j] = -1;
                }
            }
            result[i] = row;
        }

        List<(int row, int col, int count)> GetValidUnseenNeighbours(int row, int col, int count)
        {
            var valid = (int r, int c) => r >= 0 && r < height && c >= 0 && c < width;
            var unseen = (int r, int c) => result[r][c] == -1;
            var nextCount = count + 1;
            List<(int row, int col, int count)> candidates = [(row - 1, col, nextCount), (row + 1, col, nextCount), (row, col - 1, nextCount), (row, col + 1, nextCount)];
            var validUnseenNeighbours = candidates.Where(i => valid(i.row, i.col) && unseen(i.row, i.col)).ToList();
            return validUnseenNeighbours;
        }

        while (q.TryDequeue(out var curr))
        {
            var neighbours = GetValidUnseenNeighbours(curr.row, curr.col, curr.count);
            foreach (var n in neighbours)
            {
                result[n.row][n.col] = n.count;
                q.Enqueue(n);
            }
        }

        return result;
    }
}