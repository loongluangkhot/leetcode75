package org.example.leetcode;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(List<Integer> lst) {
        int len = lst.size();
        int depth = (int)(Math.log(len) / Math.log(2));
        Queue<Pair<TreeNode, TreeNode>> currLevel = new LinkedList<>();
        Queue<Pair<TreeNode, TreeNode>> prevLevel = new LinkedList<>();
        int i = len - 1;
        while(depth > 1) {
            int currWidth = getWidth(depth - 1);
            int stopIndex = i - currWidth;
            while(i > stopIndex) {
                Integer rightVal = lst.get(i--);
                Integer leftVal = lst.get(i--);
                TreeNode rightNode = rightVal != null ? new TreeNode(rightVal) : null;
                TreeNode leftNode = leftVal != null ? new TreeNode(leftVal) : null;
                Pair<TreeNode, TreeNode> pair = new Pair<>(leftNode, rightNode);
                currLevel.add(pair);

                Pair<TreeNode, TreeNode> rightNodeChildren = prevLevel.isEmpty() ? null : prevLevel.remove();
                Pair<TreeNode, TreeNode> leftNodeChildren = prevLevel.isEmpty() ? null : prevLevel.remove();

                if(rightNode != null && rightNodeChildren != null) {
                    rightNode.left = rightNodeChildren.item1;
                    rightNode.right = rightNodeChildren.item2;
                }

                if(leftNode != null && leftNodeChildren != null) {
                    leftNode.left = leftNodeChildren.item1;
                    leftNode.right = leftNodeChildren.item2;
                }
            }
            prevLevel = currLevel;
            currLevel = new LinkedList<>();
            depth--;
        }

        this.val = lst.get(0);
        if(!prevLevel.isEmpty()) {
            Pair<TreeNode, TreeNode> rootChildren = prevLevel.remove();
            this.left = rootChildren.item1;
            this.right = rootChildren.item2;
        }
    }

    private List<Integer> toList() {
        List<Integer> lst = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(this);
        int row = 0;
        boolean hasNextRow = true;
        while(hasNextRow) {
            hasNextRow = false;
            int width = getWidth(row);
            for(int i = 0; i < width; i++) {
                TreeNode curr = q.remove();
                if(curr != null) {
                    lst.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                    if(curr.left != null || curr.right != null) {
                        hasNextRow = true;
                    }
                } else {
                    // Null children
                    lst.add(null);
                    q.add(null);
                    q.add(null);
                }
            }


            row++;
        }
        return lst;
    }

    private int getWidth(int row) {
        return (int)Math.pow(2, row);
    }

    @Override
    public boolean equals(Object obj) {
        List<Integer> a = this.toList();
        List<Integer> b = ((TreeNode)obj).toList();
        return a.equals(b);
    }
}
