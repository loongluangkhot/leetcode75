package org.example.leetcode.BinarySearch;

public class GuessNumberHigherOrLower {
    int picked;
    public GuessNumberHigherOrLower(int picked) {
        this.picked = picked;
    }

    private int guess(int n) {
        return Integer.compare(picked, n);
    }

    public int guessNumber(int n) {
        double lower = 1;
        double upper = n;
        int mid = (int)((lower + upper) / 2);
        int result = guess(mid);
        while(result != 0) {
            if(result == -1) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }

            mid = (int)((lower + upper) / 2);
            result = guess(mid);
        }
        return mid;
    }
}
