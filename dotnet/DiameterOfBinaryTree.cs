#!/usr/bin/env dotnet
// https://leetcode.com/problems/diameter-of-binary-tree/description/

// Definition for a binary tree node.
public class TreeNode
{
    public int val;
    public TreeNode? left;
    public TreeNode? right;
    public TreeNode(int val = 0, TreeNode? left = null, TreeNode? right = null)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution
{
    public int DiameterOfBinaryTree(TreeNode root)
    {
        var maxDiameter = 0;

        int Dfs(TreeNode? node)
        {
            if (node == null)
            {
                return 0;
            }

            var l = Dfs(node.left);
            var r = Dfs(node.right);
            maxDiameter = Math.Max(maxDiameter, l + r);
            return Math.Max(l, r) + 1;
        }
        
        Dfs(root);
        return maxDiameter;
    }
}