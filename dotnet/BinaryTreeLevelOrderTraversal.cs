#!/usr/bin/env dotnet
// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode? left;
    public TreeNode? right;
    public TreeNode(int val=0, TreeNode? left=null, TreeNode? right=null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode? root) {
        var result = new List<IList<int>>();
        if (root == null) return result;

        var q = new Queue<TreeNode>();
        q.Enqueue(root);
        while (q.Count > 0)
        {
            var count = q.Count;
            var level = new List<int>();
            for (var i = 0; i < count; i++)
            {
                var n = q.Dequeue();
                level.Add(n.val);
                if (n.left != null) q.Enqueue(n.left);
                if (n.right != null) q.Enqueue(n.right);
            }
            result.Add(level);
        }
        return result;
    }
}