package org.example.leetcode.ArrayOrString;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int len = word1.length() + word2.length();
        char[] arr = new char[len];
        int word1Index = 0;
        int word2Index = 0;
        while(word1Index + word2Index < len) {
            if(word1Index < word1.length()) {
                arr[word1Index + word2Index] = word1.charAt(word1Index);
                word1Index++;
            }
            if(word2Index < word2.length()) {
                arr[word1Index + word2Index] = word2.charAt(word2Index);
                word2Index++;
            }
        }
        return String.valueOf(arr);
    }
}