#!/usr/bin/env dotnet
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

var s = new Solution();

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Console.WriteLine(s.LengthOfLongestSubstring("abcabcbb"));

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
Console.WriteLine(s.LengthOfLongestSubstring("bbbbb"));

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Console.WriteLine(s.LengthOfLongestSubstring("pwwkew"));

Console.WriteLine(s.LengthOfLongestSubstring("ccbbcc")); // 2

public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        var charToLastSeenIndexMap = new Dictionary<char, int>();
        var maxLen = 0;
        var startIndex = 0;
        for (var i = 0; i < s.Length; i++)
        {
            var c = s[i];

            if (
                charToLastSeenIndexMap.TryGetValue(c, out var lastSeenIndex)
                && lastSeenIndex >= startIndex
            )
            {
                startIndex = lastSeenIndex + 1;
            }

            charToLastSeenIndexMap[c] = i;
            maxLen = Math.Max(maxLen, i - startIndex + 1);
        }
        return maxLen;
    }
}
