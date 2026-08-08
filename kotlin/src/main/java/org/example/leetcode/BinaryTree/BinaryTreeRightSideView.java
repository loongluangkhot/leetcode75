package org.example.leetcode.BinaryTree;

import org.example.leetcode.Pair;
import org.example.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    private final HashMap<Integer, Integer> _map = new HashMap<>();
    private final LinkedList<Pair<TreeNode, Integer>> _nodeQueue = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        _nodeQueue.push(new Pair<>(root, 0));
        traverse(_nodeQueue);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < _map.size(); i++) {
            result.add(_map.get(i));
        }
        return result;
    }

    public void traverse(LinkedList<Pair<TreeNode, Integer>> nodeStack) {
        while(!nodeStack.isEmpty()) {
            Pair<TreeNode, Integer> pair = nodeStack.remove();
            TreeNode node = pair.item1;
            int depth = pair.item2;
            if(node != null) {
                if(!_map.containsKey(depth)) {
                    _map.put(depth, node.val);
                }
                nodeStack.add(new Pair<>(node.right, depth + 1));
                nodeStack.add(new Pair<>(node.left, depth + 1));
            }
        }
    }
}
