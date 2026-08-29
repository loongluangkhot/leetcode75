#!/usr/bin/env dotnet
// https://leetcode.com/problems/min-stack/description/

public class MinStack
{
    private readonly Stack<int> _valStack = new Stack<int>();
    private readonly Stack<int> _minStack = new Stack<int>();

    public MinStack() { }

    public void Push(int value)
    {
        _valStack.Push(value);
        if (_minStack.TryPeek(out var min))
        {
            _minStack.Push(Math.Min(min, value));
        }
        else
        {
            _minStack.Push(value);
        }
    }

    public void Pop()
    {
        _valStack.Pop();
        _minStack.Pop();
    }

    public int Top()
    {
        return _valStack.Peek();
    }

    public int GetMin()
    {
        return _minStack.Peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(value);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */
