#!/usr/bin/env dotnet
// https://leetcode.com/problems/implement-trie-prefix-tree/description/

var t = new Trie();
t.Insert("apple");
Console.WriteLine(t.Search("apple"));

public class Node(char val)
{
    private readonly char _val = val;
    private readonly Node[] _children = new Node['z' - 'a' + 1];
    public bool IsEndOfWord { get; set; } = false;

    public Node AddChild(char val)
    {
        if (_children[GetIndex(val)] == null)
        {
            _children[GetIndex(val)] = new Node(val);
        }
        return _children[GetIndex(val)];
    }

    private int GetIndex(char c)
    {
        return c - 'a';
    }

    public bool TryGetChild(char val, out Node child)
    {
        child = null!;
        if (_children[GetIndex(val)] == null)
        {
            return false;
        }

        child = _children[GetIndex(val)];
        return true;
    }
}

public class Trie
{
    private readonly Node _root;

    public Trie()
    {
        _root = new Node('^');
    }

    public void Insert(string word)
    {
        var curr = _root;
        foreach (var c in word)
        {
            curr = curr.AddChild(c);
        }
        curr.IsEndOfWord = true;
    }

    public bool Search(string word)
    {
        var curr = _root;
        foreach (var c in word)
        {
            if (curr.TryGetChild(c, out var child))
            {
                curr = child;
            }
            else
            {
                return false;
            }
        }
        return curr.IsEndOfWord;
    }

    public bool StartsWith(string prefix)
    {
        var curr = _root;
        foreach (var c in prefix)
        {
            if (curr.TryGetChild(c, out var child))
            {
                curr = child;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
