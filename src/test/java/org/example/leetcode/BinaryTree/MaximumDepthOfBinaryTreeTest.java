package org.example.leetcode.BinaryTree;

import org.example.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDepthOfBinaryTreeTest {

    @Test
    public void shouldReturnMaxDepthForThreeLevelTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        int maxDepth = tree.maxDepth(root);

        assertEquals(3, maxDepth);
    }

    @Test
    public void shouldReturnMaxDepthForTwoLevelTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        int maxDepth = tree.maxDepth(root);

        assertEquals(2, maxDepth);
    }

}