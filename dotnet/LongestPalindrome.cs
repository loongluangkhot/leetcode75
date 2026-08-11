var s = new Solution();

Console.WriteLine((int)'A'); // 65
Console.WriteLine((int)'a'); // 97

public class Solution {
    public int LongestPalindrome(string s) {
        var charCountMap = new int[('Z' - 'A' + 1) * 2];
        foreach (var c in s)
        {
            charCountMap[GetCharIndex(c)]++;
        }

        var hasMid = false;
        var result = 0;
        for (var i = 0; i < charCountMap.Length; i++)
        {
            var v = charCountMap[i];
            var toAdd = v / 2 * 2;
            result += toAdd;

            if (!hasMid && toAdd != v)
            {
                hasMid = true;
                result++;
            }
        }

        return result;
    }

    private int GetCharIndex(char c)
    {
        return c >= 'a' ? (c - 'a') + ('Z' - 'A' + 1) : c - 'A';
    }
}