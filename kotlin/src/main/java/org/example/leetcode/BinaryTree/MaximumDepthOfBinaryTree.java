package org.example.leetcode.BinaryTree;

import org.example.leetcode.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return traverse(root, 0);
    }

    public int traverse(TreeNode currNode, int depth) {
        if(currNode == null) {
            return depth;
        } else {
            depth++;
            int leftDepth = traverse(currNode.left, depth);
            int rightDepth = traverse(currNode.right, depth);
            return Math.max(leftDepth, rightDepth);
        }
    }
}
