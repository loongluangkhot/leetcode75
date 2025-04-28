package org.example.leetcode.Stack;

public class RemovingStarsFromAString {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int skip = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c != '*') {
                if(skip == 0) {
                    sb.append(c);
                }
                skip = Math.max(skip - 1, 0);
            } else {
                skip++;
            }
        }
        return sb.reverse().toString();
    }
}
