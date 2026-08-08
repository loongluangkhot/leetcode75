package org.example.leetcode.Stack;

import java.util.ArrayList;
import java.util.List;

class StockSpanner {
    private List<Integer> prices = new ArrayList<>();
    public StockSpanner() {

    }

    public int next(int price) {
        prices.add(price);
        var cnt = 0;
        for (var i = prices.size() - 1; i >= 0; i--) {
            if (price >= prices.get(i)) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
