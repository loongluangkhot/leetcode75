package org.example.leetcode.Backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public Map<Character, char[]> keymap = Map.of(
            '2', new char[] {'a', 'b', 'c'},
            '3', new char[] {'d', 'e', 'f'},
            '4', new char[] {'g', 'h', 'i'},
            '5', new char[] {'j', 'k', 'l'},
            '6', new char[] {'m', 'n', 'o'},
            '7', new char[] {'p', 'q', 'r', 's'},
            '8', new char[] {'t', 'u', 'v'},
            '9', new char[] {'w', 'x', 'y', 'z'}
    );
    public List<String> letterCombinations(String digits) {
        Queue<String> result = new LinkedList<>();
        for (var digit : digits.toCharArray()) {
            formWords(result, digit);
        }
        return result.stream().toList();
    }

    private void formWords(Queue<String> words, char nextDigit) {
        int len = words.size();

        if (len == 0) {
            char[] chars = keymap.get(nextDigit);
            for (var c : chars) {
                words.add("" + c);
            }
        }

        for (int i = 0; i < len; i++) {
            var currWord = words.remove();
            char[] chars = keymap.get(nextDigit);
            for (var c : chars) {
                words.add(currWord + c);
            }
        }
    }
}
