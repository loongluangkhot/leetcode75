package org.example.leetcode.Queue;

import java.util.LinkedList;

public class NumberOfRecentCalls {

//    // Solution1
//    private final ArrayList<Integer> requests = new ArrayList<>();
//    public int ping(int t) {
//        int cnt = 0;
//        int threshold = t - 3000;
//        for(int i = requests.size() - 1; i >= 0; i--) {
//            if(requests.get(i) >= threshold) {
//                cnt++;
//            } else {
//                break;
//            }
//        }
//        requests.add(t);
//        return cnt;
//    }

    // Solution2
    private final LinkedList<Integer> requests = new LinkedList<>();
    public int ping(int t) {
        int threshold = t - 3000;
        requests.add(t);
        while(requests.get(0) < threshold) {
            requests.remove(0);
        }
        return requests.size();
    }
}
