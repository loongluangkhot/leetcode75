var s = new Solution();
Console.WriteLine(s.CanConstruct("a", "b")); // false
Console.WriteLine(s.CanConstruct("aa", "ab")); // false
Console.WriteLine(s.CanConstruct("aa", "aab")); // true


public class Solution {
    public bool CanConstruct(string ransomNote, string magazine) {
        var magazineCharCount = new int['z' - 'a' + 1];
        foreach (var c in magazine)
        {
            magazineCharCount[c - 'a']++;
        }

        foreach (var c in ransomNote)
        {
            if (magazineCharCount[c - 'a'] <= 0)
            {
                return false;
            }
            else
            {
                magazineCharCount[c - 'a']--;
            }
        }

        return true;
    }
}