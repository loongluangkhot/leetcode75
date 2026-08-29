#!/usr/bin/env dotnet
// https://leetcode.com/problems/coin-change/description/

var s = new Solution();
Console.WriteLine(s.CoinChange([1, 2, 5], 11)); // 3
Console.WriteLine(s.CoinChange([2], 3)); // -1
Console.WriteLine(s.CoinChange([1], 0)); // 0
Console.WriteLine(s.CoinChange([186, 419, 83, 408], 6249)); // 20

public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        Array.Sort(coins);

        var dp = new int?[amount + 1];
        dp[0] = 0;

        for (var i = 1; i <= amount; i++)
        {
            int? result = null;
            for (var j = 0; j < coins.Length; j++)
            {
                var denom = coins[j];
                if (denom > i)
                {
                    break;
                }
                var resultLessDenom = dp[i - denom];
                if (resultLessDenom != null)
                {
                    result =
                        result == null
                            ? resultLessDenom + 1
                            : Math.Min(result.Value, resultLessDenom.Value + 1);
                }
            }
            dp[i] = result;
        }

        return dp[amount] != null ? dp[amount]!.Value : -1;
    }
}
