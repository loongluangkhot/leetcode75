#!/usr/bin/env dotnet
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

var s = new Solution();
Console.WriteLine(s.MaxProfit([7, 1, 5, 3, 6, 4]));
Console.WriteLine(s.MaxProfit([7, 6, 4, 3, 1]));

public class Solution
{
    public int MaxProfit(int[] prices)
    {
        var maxProfit = 0;
        var i = 0;
        var j = 1;

        while (j < prices.Length)
        {
            var buyPrice = prices[i];
            var sellPrice = prices[j];
            var profit = sellPrice - buyPrice;
            maxProfit = Math.Max(maxProfit, profit);

            if (sellPrice < buyPrice)
            {
                i = j;
            }
            j++;
        }

        return maxProfit;
    }
}
