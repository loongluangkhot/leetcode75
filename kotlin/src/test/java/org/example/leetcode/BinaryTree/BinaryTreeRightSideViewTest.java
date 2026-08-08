package org.example.leetcode.BinaryTree;

import org.example.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeRightSideViewTest {
    @Test
    public void shouldReturnRightSideViewWhenTreeIsBalanced() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView view = new BinaryTreeRightSideView();
        List<Integer> result = view.rightSideView(root);

        assertEquals(Arrays.asList(1,3,4), result);
    }

    @Test
    public void shouldReturnRightSideViewWhenTreeIsUnbalanced() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        BinaryTreeRightSideView view = new BinaryTreeRightSideView();
        List<Integer> result = view.rightSideView(root);

        assertEquals(Arrays.asList(1,3,4,5), result);
    }

}