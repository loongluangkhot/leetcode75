#!/usr/bin/env dotnet
// https://leetcode.com/problems/add-binary/description/

using System.Text;

var s = new Solution();
Console.WriteLine(s.AddBinary("111", "111")); // 1110
Console.WriteLine(s.AddBinary("11", "1")); // 100

public class Solution
{
    public string? AddBinary(string a, string b)
    {
        var (shorterStr, longerStr) = a.Length < b.Length ? (a, b) : (b, a);
        var shortLen = shorterStr.Length;
        var longLen = longerStr.Length;

        var carry = 0;
        var sb = new StringBuilder();

        var i = 0;
        while (i < shortLen)
        {
            var (bit, bitCarry) = AddBit(
                shorterStr[shortLen - 1 - i] - '0',
                longerStr[longLen - 1 - i] - '0',
                carry
            );
            sb.Append(bit);
            carry = bitCarry;
            i++;
        }
        while (i < longLen)
        {
            var (bit, bitCarry) = AddBit(0, longerStr[longLen - 1 - i] - '0', carry);
            sb.Append(bit);
            carry = bitCarry;
            i++;
        }

        if (carry > 0)
        {
            sb.Append(carry);
        }

        return new string([.. sb.ToString().Reverse()]);
    }

    public (int result, int carry) AddBit(int a, int b, int carry)
    {
        var val = a + b + carry;
        return (val % 2, val / 2);
    }
}
