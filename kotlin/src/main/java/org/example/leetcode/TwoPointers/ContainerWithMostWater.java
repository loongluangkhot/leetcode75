package org.example.leetcode.TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j-i);
                max = Math.max(area, max);
            }
        }
        return max;
    }
}

