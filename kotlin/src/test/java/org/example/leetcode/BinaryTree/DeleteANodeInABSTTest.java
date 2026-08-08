package org.example.leetcode.BinaryTree;

import org.example.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeleteANodeInABSTTest {
    @Test
    public void shouldDeleteNodeInABSTCorrectlyTestCase1() {
        TreeNode root = new TreeNode(Arrays.asList(5, 3, 6, 2, 4, null, 7));

        DeleteANodeInABST bst = new DeleteANodeInABST();
        TreeNode result = bst.deleteNode(root, 3);

        TreeNode expected = new TreeNode(Arrays.asList(5, 4, 6, 2, null, 7));
        assertEquals(expected, result);
    }

    @Test
    public void shouldDeleteNodeInABSTCorrectlyTestCase2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        DeleteANodeInABST bst = new DeleteANodeInABST();
        TreeNode result = bst.deleteNode(root, 0);

        assertEquals(5, result.val);
        assertEquals(3, result.left.val);
        assertEquals(2, result.left.left.val);
        assertEquals(4, result.left.right.val);
        assertEquals(6, result.right.val);
        assertEquals(7, result.right.right.val);
    }

    @Test
    public void shouldDeleteNodeInABSTCorrectlyTestCase3() {
        DeleteANodeInABST bst = new DeleteANodeInABST();
        TreeNode result = bst.deleteNode(null, 0);

        assertNull(result);
    }

    @Test
    public void shouldDeleteNodeInABSTCorrectlyTestCase4() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        DeleteANodeInABST bst = new DeleteANodeInABST();
        TreeNode result = bst.deleteNode(root, 50);

        // [60, 30, 70, null, 40, null, 80]
        assertEquals(60, result.val);
        assertEquals(30, result.left.val);
        assertEquals(70, result.right.val);
        assertNull(result.left.left);
        assertEquals(40, result.left.right.val);
        assertNull(result.right.left);
        assertEquals(80, result.right.right.val);
    }

}