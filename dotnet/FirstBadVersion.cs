#!/usr/bin/env dotnet
// https://leetcode.com/problems/first-bad-version/description/

var s = new Solution(5, 4);
Console.WriteLine(s.FirstBadVersion(5)); // 4

var s2 = new Solution(1, 1);
Console.WriteLine(s2.FirstBadVersion(1)); // 1

/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */
public class VersionControl
{
    private bool[] _versions;

    public VersionControl(int n, int bad)
    {
        _versions = new bool[n];
        while (bad - 1 < n)
        {
            _versions[bad - 1] = true;
            bad++;
        }
    }

    public bool IsBadVersion(int version)
    {
        return _versions[version - 1]; // Dummy implementation
    }
}

public class Solution : VersionControl
{
    public Solution(int n, int bad)
        : base(n, bad)
    {
        // Do nothing
    }

    public int FirstBadVersion(int n)
    {
        var i = 0;
        var j = n;

        while (i < j)
        {
            var mid = i + (j - i) / 2; // Floor division
            var val = IsBadVersion(GetVersion(mid));
            if (!val)
            {
                i = mid + 1;
            }
            else
            {
                j = mid;
            }
        }
        return GetVersion(i);
    }

    private int GetVersion(int index)
    {
        return index + 1;
    }
}
