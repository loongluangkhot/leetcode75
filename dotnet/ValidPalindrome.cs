#!/usr/bin/env dotnet
// https://leetcode.com/problems/valid-palindrome/description/

var s = new Solution();
Console.WriteLine(s.IsPalindrome("A man, a plan, a canal: Panama")); // true
Console.WriteLine(s.IsPalindrome("race a car")); // false
Console.WriteLine(s.IsPalindrome(" ")); // true

public class Solution {
    public bool IsPalindrome(string s) {
        var i = 0;
        var j = s.Length - 1;

        while (i < j)
        {
            var l = s[i];
            if (!char.IsAsciiLetter(l) && !char.IsAsciiDigit(l))
            {
                i++;
                continue;
            }
            var r = s[j];
            if (!char.IsAsciiLetter(r) && !char.IsAsciiDigit(r))
            {
                j--;
                continue;
            }

            if (char.ToLower(l) != char.ToLower(r))
            {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}