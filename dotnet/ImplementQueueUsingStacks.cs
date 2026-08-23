#!/usr/bin/env dotnet
// https://leetcode.com/problems/implement-queue-using-stacks/description/

public class MyQueue {
    private readonly Stack<int> _toAdd;
    private readonly Stack<int> _toRemove;


    public MyQueue() {
        _toAdd = new Stack<int>();
        _toRemove = new Stack<int>();
    }
    
    public void Push(int x) {
        _toAdd.Push(x);
    }
    
    public int Pop() {
        TransferIfToRemoveIsEmpty();
        return _toRemove.Pop();
    }
    
    public int Peek() {
        TransferIfToRemoveIsEmpty();
        return _toRemove.Peek();
    }

    private void TransferIfToRemoveIsEmpty()
    {
        if (_toRemove.Count == 0)
        {
            while (_toAdd.Count > 0)
            {
                _toRemove.Push(_toAdd.Pop());
            }
        }
    }
    
    public bool Empty() {
        return _toAdd.Count == 0 && _toRemove.Count == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Peek();
 * bool param_4 = obj.Empty();
 */