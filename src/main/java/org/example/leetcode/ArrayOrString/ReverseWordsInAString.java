package org.example.leetcode.ArrayOrString;

public class ReverseWordsInAString {
//    // Solution 1
//    public String reverseWords(String s) {
//        String[] tokens = s.split(" ");
//        StringBuilder reversed = new StringBuilder();
//
//        for(int i = tokens.length - 1; i >= 0; i--) {
//            String token = tokens[i];
//            if(!token.isEmpty()) {
//                reversed.append(token);
//                reversed.append(' ');
//            }
//        }
//
//        reversed.deleteCharAt(reversed.length() - 1);
//
//        return reversed.toString();
//    }

    public String reverseWords(String s) {
        char[] reversed = removeSpaces(s);

        // Reverse entire sentence
        reverseCharArray(reversed, 0, reversed.length - 1);

        // Reverse each word
        int i = 0;
        int j = 1;
        while(i < reversed.length) {
            while(j < reversed.length && reversed[j] != ' ') {
                j++;
            }
            reverseCharArray(reversed, i, j - 1);
            j++;
            i = j;
        }
        reverseCharArray(reversed, i, j - 1);
        return String.valueOf(reversed);
    }

    public char[] removeSpaces(String s) {
        int sLen = s.length();
        int prefixSpaceLen = 0;
        while(s.charAt(prefixSpaceLen) == ' ') {
            prefixSpaceLen++;
        }
        int suffixSpaceLen = 0;
        while(s.charAt(sLen - 1 - suffixSpaceLen) == ' ') {
            suffixSpaceLen++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = prefixSpaceLen; i < sLen - suffixSpaceLen; i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                sb.append(c);
            } else if (s.charAt(i + 1) != ' ') {
                sb.append(' ');
            }
        }
        return sb.toString().toCharArray();
    }

    private void reverseCharArray(char[] arr, int i, int j) {
        while(i < j) {
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
    }

}