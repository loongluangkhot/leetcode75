package org.example.leetcode.DynamicProgramming;

public class DominoAndTrominoTiling {
    // f(k) = f(k-1) + f(k-2) + p(k-1)
    // p(k) = 2f(k-2) + p(k-1)
    // f(0) = 0; f(1) = 1; f(2) = 2
    // p(0) = 0; p(1) = 0; p(2) = 2
    public int numTilings(int n) {
        if(n <= 2) {
            return n;
        }

        int mod = (int)(1e9 + 7);
        var fPrev = 1L;
        var fCurr = 2L;
        var pCurr = 2L;
        for(int i = 3; i <= n; i++) {
            var temp = fCurr;
            fCurr = (fCurr + fPrev + pCurr) % mod;
            pCurr = (2 * fPrev + pCurr) % mod;
            fPrev = temp;
        }

        return (int)fCurr;
    }
}
