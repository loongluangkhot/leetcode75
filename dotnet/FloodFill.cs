#!/usr/bin/env dotnet
// https://leetcode.com/problems/flood-fill/description/

var s = new Solution();
Console.WriteLine(s.FloodFill([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2));

public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        var s = new Stack<(int, int)>();

        var imageHeight = image.Length;
        var imageWidth = imageHeight > 0 ? image[0].Length : 0;
        var seen = new bool[imageHeight, imageWidth];
        var startingColor = image[sr][sc];

        Process(image, sr, sc, color, s, seen, startingColor, imageHeight, imageWidth);

        return image;
    }

    private void Process(int[][] image, int sr, int sc, int fillColor, Stack<(int, int)> s, bool[,] seen, int startingColor, int imageHeight, int imageWidth)
    {
        AddCell(image, sr, sc, s, seen, startingColor, imageHeight, imageWidth);
        while (s.Count > 0)
        {
            var curr = s.Pop();
            var (currRow, currCol) = curr;
            image[currRow][currCol] = fillColor;

            AddCell(image, currRow - 1, currCol, s, seen, startingColor, imageHeight, imageWidth);
            AddCell(image, currRow + 1, currCol, s, seen, startingColor, imageHeight, imageWidth);
            AddCell(image, currRow, currCol - 1, s, seen, startingColor, imageHeight, imageWidth);
            AddCell(image, currRow, currCol + 1, s, seen, startingColor, imageHeight, imageWidth);
        }
    }

    private void AddCell(int[][] image, int row, int col, Stack<(int,int)> s, bool[,] seen, int startingColor, int imageHeight, int imageWidth)
    {
        if (row >= 0 && row < imageHeight
            && col >= 0 && col < imageWidth
            && image[row][col] == startingColor 
            && !seen[row, col])
        {
            s.Push((row, col));
            seen[row, col] = true;
        }
    }
}