package org.example.leetcode.BinaryTree;

import java.util.HashMap;
import java.util.Map;

import org.example.leetcode.TreeNode;

public class PathSum3 {
    private int _count = 0;
    private int _targetSum = 0;
    private Map<Long, Integer> _prefixSumCountMap = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return _count;
        }

        _targetSum = targetSum;
        preOrder(root, 0);
        
        return _count;
    }

    private void preOrder(TreeNode node, long parentSum) {
        if (node == null) {
            return;
        }

        long currSum = parentSum + node.val;
        processCurrNode(node, currSum);
        preOrder(node.left, currSum);
        preOrder(node.right, currSum);
    }

    private void processCurrNode(TreeNode node, long currSum) {
        _count += currSum == _targetSum ? 1 : 0;

        long diff = currSum - _targetSum;
        _count += _prefixSumCountMap.getOrDefault(diff, 0);

        _prefixSumCountMap.put(currSum, _prefixSumCountMap.getOrDefault(currSum, 0) + 1);
    }
}