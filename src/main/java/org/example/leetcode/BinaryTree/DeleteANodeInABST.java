package org.example.leetcode.BinaryTree;

import org.example.leetcode.TreeNode;

public class DeleteANodeInABST {
    private TreeNode findLeftMost(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private TreeNode findRightMost(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            // Delete from left subtree
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // Delete from right subtree
            root.right = deleteNode(root.right, key);
        } else {
            // Delete root
            if(root.left == null && root.right ==  null) {
                return null;
            }

            if(root.right != null) {
                root.val = findLeftMost(root.right).val;
                deleteNode(root.right, root.val);
            } else {
                root.val = findRightMost(root.left).val;
                deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}


