#!/usr/bin/env dotnet
// https://leetcode.com/problems/valid-anagram/description/

var s = new Solution();
Console.WriteLine(s.IsAnagram("anagram", "nagaram")); // true
Console.WriteLine(s.IsAnagram("rat", "car")); // false
Console.WriteLine(s.IsAnagram("ggii", "eekk")); // false

public class Solution
{
    public bool IsAnagram(string s, string t)
    {
        if (s.Count() != t.Count())
            return false;

        var sCharCount = GetCharCount(s);
        var tCharCount = GetCharCount(t);
        for (var i = 0; i < sCharCount.Length; i++)
        {
            if (sCharCount[i] != tCharCount[i])
            {
                return false;
            }
        }
        return true;
    }

    public int[] GetCharCount(string s)
    {
        var length = 'z' - 'a' + 1;
        var charCount = new int[length];
        foreach (char i in s)
        {
            var index = i - 'a';
            charCount[index]++;
        }
        return charCount;
    }
}
