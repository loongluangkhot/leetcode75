#!/usr/bin/env dotnet
// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

public class Solution
{
    private readonly Dictionary<string, Func<long, long, long>> _ops = new()
    {
        { "+", (a, b) => a + b },
        { "-", (a, b) => a - b },
        { "*", (a, b) => a * b },
        { "/", (a, b) => a / b },
    };

    public int EvalRPN(string[] tokens)
    {
        var s = new Stack<long>();
        foreach (var n in tokens)
        {
            if (_ops.TryGetValue(n, out var op))
            {
                var b = s.Pop();
                var a = s.Pop();
                var result = op(a, b);
                s.Push(result);
            }
            else
            {
                s.Push(long.Parse(n));
            }
        }
        return (int)s.Pop();
    }
}
