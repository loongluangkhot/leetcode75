var s = new Solution();
Console.WriteLine(s.ClimbStairs(45));

// 5 steps
// 1,1, 1,1, 1
// 2,   1,1, 1
// 1,2,1,    1
// 1,1, 2,   1
// 1,1, 1, 2


public class Solution {
    public Dictionary<int, int> _cache = new Dictionary<int, int>();
    public int ClimbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (_cache.TryGetValue(n, out var result))
        {
            return result;
        } else
        {
            var val = ClimbStairs(n - 1) + ClimbStairs(n - 2);
            _cache[n] = val;
            return val;
        }
    }
}