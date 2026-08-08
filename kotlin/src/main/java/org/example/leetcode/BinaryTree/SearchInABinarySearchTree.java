package org.example.leetcode.BinaryTree;

import org.example.leetcode.TreeNode;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        } else if(val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}
