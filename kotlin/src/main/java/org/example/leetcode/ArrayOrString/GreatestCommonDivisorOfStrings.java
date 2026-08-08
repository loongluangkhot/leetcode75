package org.example.leetcode.ArrayOrString;

import java.util.Arrays;

public class GreatestCommonDivisorOfStrings {
//    // Solution 1
//    public static String gcdOfStrings(String str1, String str2) {
//        List<String> divisors1 = getDivisors(str1);
//        List<String> divisors2 = getDivisors(str2);
//        int i = 0;
//        int j = 0;
//        while(i < divisors1.size() && j < divisors2.size()) {
//            String divisor1 = divisors1.get(i);
//            String divisor2 = divisors2.get(j);
//            if(divisor1.length() == divisor2.length()) {
//                return divisor1.equals(divisor2) ? divisor1 : "";
//            } else if (divisor1.length() > divisor2.length()) {
//                i++;
//            } else {
//                j++;
//            }
//        }
//        return "";
//    }
//
//    private static List<String> getDivisors(String str1) {
//        ArrayList<String> divisors = new ArrayList<>(Collections.singleton(str1));
//        int split = 2;
//        while(split <= str1.length()) {
//            if(str1.length() % split == 0) {
//                int chunkSize = str1.length() / split;
//                int i = 0;
//                String chunk = str1.substring(i, i + chunkSize);
//                boolean hasMismatch = false;
//                while(i + chunkSize < str1.length()) {
//                    String nextChunk = str1.substring(i + chunkSize, i + 2*chunkSize);
//                    if(!chunk.equals(nextChunk)) {
//                        hasMismatch = true;
//                    }
//                    i += chunkSize;
//                    chunk = nextChunk;
//                }
//                if(!hasMismatch) {
//                    divisors.add(chunk);
//                }
//            }
//            split++;
//        }
//        return divisors;
//    }

//    // Solution 2
//    public static String gcdOfStrings(String str1, String str2) {
//        String shorter;
//        String longer;
//        if(str1.length() < str2.length()) {
//            shorter = str1;
//            longer = str2;
//        } else {
//            shorter = str2;
//            longer = str1;
//        }
//        String base = shorter;
//        while (!base.isEmpty()) {
//            if(isGcd(base, shorter, longer)) {
//                return base;
//            }
//            base = base.substring(0, base.length()-1);
//        }
//        return "";
//    }
//
//    private static boolean isGcd(String base, String shorter, String longer) {
//        if(shorter.length() % base.length() != 0 || longer.length() % base.length() != 0) {
//            return false;
//        }
//        String baseExtendedForShorter = base.repeat(shorter.length() / base.length());
//        if(!baseExtendedForShorter.equals(shorter)) {
//            return false;
//        }
//        String baseExtendedForLonger = base.repeat(longer.length() / base.length());
//        return baseExtendedForLonger.equals(longer);
//    }

//    // Solution 3
//    public static String gcdOfStrings(String str1, String str2) {
//        if(!str1.concat(str2).equals(str2.concat(str1))) {
//            return "";
//        }
//
//        int len1 = str1.length();
//        int len2 = str2.length();
//        int gcdl = Math.min(len1, len2);
//        while(gcdl > 1) {
//            if(len1 % gcdl == 0 && len2 % gcdl == 0) {
//                break;
//            }
//            if(gcdl % 2 == 0) {
//                gcdl /= 2;
//            } else {
//                gcdl /= 3;
//            }
//        }
//        return str1.substring(0, gcdl);
//    }

    public static String gcdOfStrings(String str1, String str2) {
        if(!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }

        int[] lens = new int[] {str1.length(), str2.length()};
        Arrays.sort(lens);
        int smaller = lens[0];
        int larger = lens[1];
        int r = larger % smaller;
        while(r != 0) {
            larger = smaller;
            smaller = r;
            r = larger % smaller;
        }
        return str1.substring(0, smaller);
    }
}

