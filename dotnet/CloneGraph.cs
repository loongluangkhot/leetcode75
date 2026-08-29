#!/usr/bin/env dotnet
// https://leetcode.com/problems/clone-graph/description/

// Definition for a Node.
public class Node
{
    public int val;
    public IList<Node> neighbors;

    public Node()
    {
        val = 0;
        neighbors = new List<Node>();
    }

    public Node(int _val)
    {
        val = _val;
        neighbors = new List<Node>();
    }

    public Node(int _val, List<Node> _neighbors)
    {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution
{
    public Node? CloneGraph(Node? node)
    {
        if (node == null)
        {
            return node;
        }

        var cachedCopies = new Node[100];

        return Clone(node, cachedCopies);
    }

    private Node Clone(Node node, Node[] copies)
    {
        if (copies[GetIndex(node.val)] != null)
        {
            return copies[GetIndex(node.val)];
        }

        var cloned = new Node(node.val, []);
        copies[GetIndex(cloned.val)] = cloned;

        foreach (var n in node.neighbors)
        {
            cloned.neighbors.Add(Clone(n, copies));
        }

        return cloned;
    }

    private int GetIndex(int nodeVal)
    {
        return nodeVal - 1;
    }
}
