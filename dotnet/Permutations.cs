#!/usr/bin/env dotnet
// https://leetcode.com/problems/permutations/description/
#:include utils/ConsoleUtil.cs

var s = new Solution();
s.Permute([1,2,3]).PrintJaggedArr(); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

public class Solution {
    public IList<IList<int>> Permute(int[] nums) {
        var seen = new bool[nums.Length];
        var stack = new Stack<int>();
        var result = new List<IList<int>>();

        void Dfs()
        {
            if (stack.Count == nums.Length)
            {
                result.Add(stack.ToList());
                return;
            }

            for (var i = 0; i < nums.Length; i++)
            {
                if (seen[i]) continue;
                
                seen[i] = true;
                stack.Push(nums[i]);
                Dfs();
                stack.Pop();
                seen[i] = false;
            }
        }
        Dfs();

        return result;
    }
}