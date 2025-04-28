package org.example.leetcode.Queue;

import java.util.HashMap;
import java.util.LinkedList;

public class Dota2Senate {
//    // Solution 1
//    public String predictPartyVictory(String senate) {
//        char[] senateArr = senate.toCharArray();
//        for(int i = 0; i < senateArr.length; i = (i + 1) % senateArr.length) {
//            char party = senateArr[i];
//            if(party == 'X') {
//                continue;
//            }
//            if(!banNextOpponent(senateArr, getOppParty(party), i)) {
//                return party == 'D' ? "Dire" : "Radiant";
//            }
//        }
//        return "";
//    }
//
//    private boolean banNextOpponent(char[] senateArr, char partyToBand, int currPos) {
//        for(int i = (currPos + 1) % senateArr.length; i < senateArr.length; i = (i + 1) % senateArr.length) {
//            char party = senateArr[i];
//            if(i == currPos) {
//                return false;
//            }
//            if(party == partyToBand) {
//                senateArr[i] = 'X';
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private char getOppParty(char party) {
//        return party == 'D' ? 'R' : 'D';
//    }

//    // Solution 2
//    public String predictPartyVictory(String senate) {
//        int len = senate.length();
//        LinkedList<Integer> dQ = new LinkedList<>();
//        LinkedList<Integer> rQ = new LinkedList<>();
//        for(int i = 0; i < senate.length(); i++) {
//            char c = senate.charAt(i);
//            if(c == 'D') {
//                dQ.add(i);
//            } else {
//                rQ.add(i);
//            }
//        }
//        for(int i = 0; i < len; i = (i + 1) % len) {
//            if(!dQ.isEmpty() && i == dQ.peek()) {
//                if(rQ.isEmpty()) {
//                    return "Dire";
//                } else {
//                    rQ.remove();
//                    int d = dQ.remove();
//                    dQ.add(d);
//                }
//            } else if (!rQ.isEmpty() && i == rQ.peek()) {
//                if(dQ.isEmpty()) {
//                    return "Radiant";
//                } else {
//                    dQ.remove();
//                    int r = rQ.remove();
//                    rQ.add(r);
//                }
//            }
//        }
//        return "";
//    }

//    // Solution 3
//    public String predictPartyVictory(String senate) {
//        LinkedList<Integer> dQ = new LinkedList<>();
//        LinkedList<Integer> rQ = new LinkedList<>();
//        for(int i = 0; i < senate.length(); i++) {
//            char c = senate.charAt(i);
//            if(c == 'D') {
//                dQ.add(i);
//            } else {
//                rQ.add(i);
//            }
//        }
//        LinkedList<Integer> dQNext = new LinkedList<>();
//        LinkedList<Integer> rQNext = new LinkedList<>();
//        while(true) {
//            int d = dQ.isEmpty() ? Integer.MAX_VALUE : dQ.peekFirst();
//            int r = rQ.isEmpty() ? Integer.MAX_VALUE : rQ.peekFirst();
//            if(d < r) {
//                boolean removed = ban(rQ, rQNext, dQ, dQNext);
//                if (!removed) return "Dire";
//            } else {
//                boolean removed = ban(dQ, dQNext, rQ, rQNext);
//                if (!removed) return "Radiant";
//            }
//
//            if(dQ.isEmpty() && rQ.isEmpty()) {
//                dQ = dQNext;
//                dQNext = new LinkedList<>();
//
//                rQ = rQNext;
//                rQNext = new LinkedList<>();
//            }
//        }
//    }
//
//    private static boolean ban(LinkedList<Integer> oppPartyQ, LinkedList<Integer> oppPartyQNext, LinkedList<Integer> ownPartyQ, LinkedList<Integer> ownPartyQNext) {
//        if(oppPartyQ.isEmpty()) {
//            if(oppPartyQNext.isEmpty()) {
//                return false;
//            }
//            oppPartyQNext.removeFirst();
//        } else {
//            oppPartyQ.removeFirst();
//        }
//        ownPartyQNext.add(ownPartyQ.removeFirst());
//        return true;
//    }

    public String predictPartyVictory(String senate) {
        HashMap<Character, Integer> numMap = new HashMap<>();
        numMap.put('D', 0);
        numMap.put('R', 0);
        HashMap<Character, Integer> banNumMap = new HashMap<>();
        banNumMap.put('D', 0);
        banNumMap.put('R', 0);
        LinkedList<Character> senateLst = new LinkedList<>();
        for(char c : senate.toCharArray()) {
            senateLst.add(c);
            numMap.put(c, numMap.get(c) + 1);
        }

        while(true) {
            char c = senateLst.remove();
            int banNum = banNumMap.get(c);
            if(banNum > 0) {
                banNumMap.put(c, banNum - 1);
            } else {
                senateLst.add(c);

                char opp = getOpponent(c);
                int oppNewCnt = numMap.get(opp) - 1;
                if(oppNewCnt <= 0) {
                    return c == 'D' ? "Dire" : "Radiant"; // Opponent ran out of senators. Party wins.
                }
                numMap.put(opp, oppNewCnt);

                banNumMap.put(opp, banNumMap.get(opp) + 1);
            }
        }
    }
    private char getOpponent(char party) {
        return party == 'D' ? 'R' : 'D';
    }

}

// DDRRR
// D [0, 1]
// R [4]
