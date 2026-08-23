#!/usr/bin/env dotnet
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

// Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode? left;
    public TreeNode? right;
    public TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        var common = root;
        var pCurr = root;
        var qCurr = root;

        while (true)
        {
            // Move pCurr
            if (p.val < pCurr!.val)
            {
                pCurr = pCurr.left;
            }
            else if (p.val > pCurr.val)
            {
                pCurr = pCurr.right;
            }

            // Move qCurr
            if (q.val < qCurr!.val)
            {
                qCurr = qCurr.left;
            }
            else if (q.val > qCurr.val)
            {
                qCurr = qCurr.right;
            }

            // Update common or return
            if (pCurr == qCurr)
            {
                common = pCurr;
            } 
            else
            {
                return common!;
            }
        }
    }
}