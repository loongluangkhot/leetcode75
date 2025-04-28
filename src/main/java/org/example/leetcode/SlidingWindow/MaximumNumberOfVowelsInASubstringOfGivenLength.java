package org.example.leetcode.SlidingWindow;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int i = 0;
        int j = 0;
        int vowelNum = 0;
        while(j < k) {
            if(isVowel(s.charAt(j))) {
                vowelNum++;
            }
            j++;
        }
        int maxVowelNum = vowelNum;
        while(j < s.length()) {
            if(isVowel(s.charAt(i))) {
                vowelNum--;
            }
            if(isVowel(s.charAt(j))) {
                vowelNum++;
            }
            maxVowelNum = Math.max(maxVowelNum, vowelNum);
            i++;
            j++;
        }
        return maxVowelNum;
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
