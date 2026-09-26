#!/usr/bin/env dotnet
// https://leetcode.com/problems/combination-sum/description/
#:include utils/ConsoleUtil.cs

var s = new Solution();
s.CombinationSum([2,3,6,7], 7).PrintJaggedArr(); // [[3,2,2], [7]]
s.CombinationSum([8,7,4,3], 11).PrintJaggedArr(); // [[8,3],[7,4],[4,4,3]]

public class Solution
{
    public IList<IList<int>> CombinationSum(int[] candidates, int target)
    {
        Array.Sort(candidates);
        
        var result = new List<IList<int>>();
        var stack = new Stack<int>();
        var currSum = 0;

        Dfs(0);

        void Dfs(int i)
        {
            while (i < candidates.Length)
            {
                var val = candidates[i];
                currSum += val;
                stack.Push(val);

                if (currSum >= target)
                {
                    if (currSum == target)
                    {
                        result.Add(stack.ToList());
                    }
                    stack.Pop();
                    currSum -= val;
                    return;
                }

                Dfs(i);
                stack.Pop();
                currSum -= val;
                
                i++;
            }
        }

        return result;
    }
}