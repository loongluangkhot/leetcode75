var s = new Solution();
Console.WriteLine(s.Search([-1,0,3,5,9,12], 9)); // 4
Console.WriteLine(s.Search([-1,0,3,5,9,12], 2)); // -1



public class Solution {
    public int Search(int[] nums, int target) {
        var length = nums.Length;

        var i = 0;
        var j = length;

        while (i < j)
        {
            var mid = i + (j - i) / 2; // Floor division
            var val = nums[mid];
            if (val < target)
            {
                i = mid + 1;
            }
            else
            {
                j = mid;
            }
        }
        
        return nums[i] == target ? i : -1;
    }
}