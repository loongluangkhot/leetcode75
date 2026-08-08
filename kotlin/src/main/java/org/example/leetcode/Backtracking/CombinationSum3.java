package org.example.leetcode.Backtracking;

import java.util.*;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * <p>
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 * <p>
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        var results = new ArrayList<List<Integer>>();
        var linkedList = new LinkedList<Integer>();
        for (int i = 1; i < 10; i++) {
            linkedList.add(i);
            checkCombinationSum(k, n, linkedList, results);
            linkedList.removeLast();
        }
        return results;
    }

    private void checkCombinationSum(int k, int n, LinkedList<Integer> currentSet, ArrayList<List<Integer>> results) {
        if (currentSet.size() == k && currentSet.stream().mapToInt(Integer::intValue).sum() == n) {
            results.add(List.copyOf(currentSet));
        } else if (currentSet.size() < k && currentSet.stream().mapToInt(Integer::intValue).sum() < n) {
            var lastVal = currentSet.getLast();
            for (int i = lastVal + 1; i < 10; i++) {
                currentSet.add(i);
                checkCombinationSum(k, n, currentSet, results);
                currentSet.removeLast();
            }
        }
    }
}
