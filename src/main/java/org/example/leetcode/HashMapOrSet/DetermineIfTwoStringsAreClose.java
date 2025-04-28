package org.example.leetcode.HashMapOrSet;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {
//    // Solution 1
//    public boolean closeStrings(String word1, String word2) {
//        if(word1.length() != word2.length()) {
//            return false;
//        }
//        HashMap<Character, Integer> cSet1 = new HashMap<>();
//        char[] cArr1 = word1.toCharArray();
//        for(char c : cArr1) {
//            if(cSet1.containsKey(c)) {
//                cSet1.put(c, cSet1.get(c) + 1);
//            } else {
//                cSet1.put(c, 1);
//            }
//        }
//
//        HashMap<Character, Integer> cSet2 = new HashMap<>();
//        char[] cArr2 = word2.toCharArray();
//        for(char c : cArr2) {
//            if(!cSet1.containsKey(c)) {
//                return false;
//            }
//            if(cSet2.containsKey(c)) {
//                cSet2.put(c, cSet2.get(c) + 1);
//            } else {
//                cSet2.put(c, 1);
//            }
//        }
//
//        List<Integer> countLst1 = cSet1.values().stream().sorted().toList();
//        List<Integer> countLst2 = cSet2.values().stream().sorted().toList();
//        for(int i = 0; i < countLst1.size(); i++) {
//            if(!Objects.equals(countLst1.get(i), countLst2.get(i))) {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    // Solution2: bucket
//    public boolean closeStrings(String word1, String word2) {
//        int[] alphaCnt1 = new int[26];
//        for(char c : word1.toCharArray()) {
//            alphaCnt1[Character.toLowerCase(c) - 'a'] += 1;
//        }
//
//        int[] alphaCnt2 = new int[26];
//        int alphaBit2 = 0;
//        for(char c : word2.toCharArray()) {
//            alphaCnt2[Character.toLowerCase(c) - 'a'] += 1;
//        }
//
//        for(int i = 0; i < 26; i++) {
//            if((alphaCnt1[i] == 0 && alphaCnt2[i] != 0) || (alphaCnt2[i] == 0 && alphaCnt1[i] != 0)) {
//                return false;
//            }
//        }
//
//        Arrays.sort(alphaCnt1);
//        Arrays.sort(alphaCnt2);
//
//        return Arrays.equals(alphaCnt1, alphaCnt2);
//    }

    // Solution3: bit
    public boolean closeStrings(String word1, String word2) {
        int[] alphaCnt1 = new int[26];
        int alphaBitMap1 = 0;
        for (char c : word1.toCharArray()) {
            char cLower = Character.toLowerCase(c);
            alphaCnt1[cLower - 'a'] += 1;
            alphaBitMap1 = alphaBitMap1 | (1 << (cLower - 'a'));
        }

        int[] alphaCnt2 = new int[26];
        int alphaBitMap2 = 0;
        for (char c : word2.toCharArray()) {
            char cLower = Character.toLowerCase(c);
            alphaCnt2[Character.toLowerCase(c) - 'a'] += 1;
            alphaBitMap2 = alphaBitMap2 | (1 << (cLower - 'a'));

        }

        if(alphaBitMap1 != alphaBitMap2) {
            return false;
        }

        Arrays.sort(alphaCnt1);
        Arrays.sort(alphaCnt2);

        return Arrays.equals(alphaCnt1, alphaCnt2);
    }
}
