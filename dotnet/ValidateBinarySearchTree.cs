#!/usr/bin/env dotnet
// https://leetcode.com/problems/validate-binary-search-tree/description/

// Definition for a binary tree node.
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution
{
    public bool IsValidBST(TreeNode root)
    {
        (bool isValid, int min, int max) Dfs(TreeNode root)
        {
            var currMin = root.val;
            var currMax = root.val;
            if (root.left != null)
            {
                var leftResult = Dfs(root.left);
                currMin = Math.Min(currMin, leftResult.min);
                currMax = Math.Max(currMax, leftResult.max);
                if (!(leftResult.isValid && root.val > leftResult.max))
                {
                    return (false, 0, 0);
                }
            }

            if (root.right != null)
            {
                var rightResult = Dfs(root.right);
                currMin = Math.Min(currMin, rightResult.min);
                currMax = Math.Max(currMax, rightResult.max);
                if (!(rightResult.isValid && root.val < rightResult.min))
                {
                    return (false, 0, 0);
                }
            }

            return (true, currMin, currMax);
        }

        var result = Dfs(root);
        return result.isValid;
    }
}
