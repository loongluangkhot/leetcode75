#!/usr/bin/env dotnet
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

// [3,5,1,6,2,0,8,null,null,7,4]
var s = new Solution();
var root = new TreeNode(3);
root.left = new TreeNode(5);
root.right = new TreeNode(1);
Console.WriteLine(s.LowestCommonAncestor(root, root.left, root.right).val);

// Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>? pTrace = null;
        List<TreeNode>? qTrace = null;

        var stack = new Stack<TreeNode>();

        void Dfs(TreeNode root)
        {
            stack.Push(root);

            if (root == p)
            {
                pTrace = stack.Reverse().ToList();
            }
            if (root == q)
            {
                qTrace = stack.Reverse().ToList();
            }

            if (pTrace != null && qTrace != null)
            {
                return;
            }

            if (root.left != null)
            {
                Dfs(root.left);
            }

            if (root.right != null)
            {
                Dfs(root.right);
            }

            stack.Pop();
        }

        Dfs(root);

        var i = 0;
        while (i < Math.Min(pTrace!.Count, qTrace!.Count))
        {
            if (pTrace[i] != qTrace[i])
            {
                break;
            }
            i++;
        }
        return pTrace[i-1];
    }
}