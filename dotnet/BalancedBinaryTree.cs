#!/usr/bin/env dotnet
// https://leetcode.com/problems/balanced-binary-tree/description/

var s = new Solution();

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

// public class Solution
// {
//     private Dictionary<TreeNode, int> _depthCache = new Dictionary<TreeNode, int>();

//     public bool IsBalanced(TreeNode? root)
//     {
//         if (root == null)
//         {
//             return true;
//         }

//         return IsBalanced(root.left) && IsBalanced(root.right) && IsBalancedInternal(root);
//     }

//     private bool IsBalancedInternal(TreeNode node)
//     {
//         var leftDepth = GetDepth(node.left);
//         var rightDepth = GetDepth(node.right);

//         return Math.Abs(leftDepth - rightDepth) <= 1;
//     }

//     private int GetDepth(TreeNode? node)
//     {
//         if (node == null)
//         {
//             return -1;
//         }

//         if (_depthCache.ContainsKey(node))
//         {
//             return _depthCache[node];
//         }

//         var depth = Math.Max(GetDepth(node.left), GetDepth(node.right)) + 1;
//         _depthCache[node] = depth;

//         return depth;
//     }
// }

public class Solution
{
    private (int height, bool balanced) Check(TreeNode? node)
    {
        if (node == null) return (0, true);

        var (leftHeight, leftBalanced) = Check(node.left);
        var (rightHeight, rightBalanced) = Check(node.right);

        var balanced = leftBalanced && rightBalanced && Math.Abs(leftHeight - rightHeight) <= 1;
        return (Math.Max(leftHeight, rightHeight) + 1, balanced);
    }

    public bool IsBalanced(TreeNode? root) => Check(root).balanced;
}

// public class Solution
// {
//     public bool IsBalanced(TreeNode? root) => Height(root) != -1;

//     private int Height(TreeNode? node)
//     {
//         if (node == null) return 0;

//         var left = Height(node.left);
//         if (left == -1) return -1;

//         var right = Height(node.right);
//         if (right == -1) return -1;

//         return Math.Abs(left - right) > 1 
//             ? -1 
//             : Math.Max(left, right) + 1;
//     }
// }