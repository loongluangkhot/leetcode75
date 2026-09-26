#!/usr/bin/env dotnet
// https://leetcode.com/problems/minimum-window-substring/description/

using Microsoft.VisualBasic;

var s = new Solution();
Console.WriteLine(s.MinWindow("ADOBECODEBANC", "ABC")); // "BANC"
Console.WriteLine(s.MinWindow("a", "a")); // "a"
Console.WriteLine(s.MinWindow("a", "aa")); // ""

public class Solution
{
    public string MinWindow(string s, string t)
    {
        var missing = t.Length;
        var tMap = t.GroupBy(i => i).ToDictionary(g => g.Key, g => g.Count());
        (int Start, int End)? result = null;

        var i = 0;
        var j = 0;

        while (j < s.Length)
        {
            var rightChar = s[j];
            if (tMap.TryGetValue(rightChar, out var cCount))
            {
                if (cCount > 0) missing--;
                tMap[rightChar]--;
            }
            
            while (missing == 0)
            {
                // Move i
                var leftChar = s[i];
                while (!tMap.TryGetValue(leftChar, out _))
                {
                    leftChar = s[++i];
                }
                
                if (result == null)
                {
                    result = (i, j);
                }
                else
                {
                    var currLen = j - i + 1;
                    var currResultLen = result.Value.End - result.Value.Start + 1;
                    if (currLen < currResultLen)
                    {
                        result = (i, j);
                    }
                }

                i++;
                tMap[leftChar]++;
                if (tMap[leftChar] > 0) missing++;
            }
            j++;
        }

        return !result.HasValue ? "" : s.Substring(result.Value.Start, result.Value.End - result.Value.Start + 1);
    }
}