var s = new Solution();
Console.WriteLine(s.IsValid("()")); // true
Console.WriteLine(s.IsValid("()[]{}")); // true
Console.WriteLine(s.IsValid("([])")); // true
Console.WriteLine(s.IsValid("([)]")); // false

public class Solution {
    private static readonly Dictionary<char, char> _bracketPairMapByClosing = new()
    {
        { ')', '(' },
        { ']', '[' },
        { '}', '{' },
    };

    public bool IsValid(string s) {
        var stack = new Stack<char>();
        foreach (var c in s)
        {
            if (_bracketPairMapByClosing.TryGetValue(c, out char expectedOpening))
            {
                if (stack.TryPop(out char popped))
                {
                    if (popped != expectedOpening)
                    {
                        return false;
                    }
                } 
                else
                {
                    return false;
                }
            } else
            {
                stack.Push(c);
            }
        }
        return stack.Count == 0;
    }
}