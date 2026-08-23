#!/usr/bin/env dotnet
// https://leetcode.com/problems/k-closest-points-to-origin/description/
#:include utils/ConsoleUtil.cs

var s = new Solution();
s.KClosest([[1,3],[-2,2]], 1).PrintJaggedArr(); // [[-2,2]]
s.KClosest([[3,3],[5,-1],[-2,4]], 2).PrintJaggedArr(); // [[3,3],[-2,4]]

// // Min-heap approach: time complexity of O(nlogn) + O(klogn) = O(nlogn) since k<=n
// public class Solution2 {
//     public int[][] KClosest(int[][] points, int k) {
//         var minHeap = new PriorityQueue<int[], double>();
//         foreach (var p in points)
//         {
//             minHeap.Enqueue(p, Math.Sqrt(Math.Pow(p[0], 2) + Math.Pow(p[1], 2)));
//         }

//         var result = new int[k][];
//         for (var i = 0; i < k; i++)
//         {
//             result[i] = minHeap.Dequeue();
//         }

//         return result;
//     }
// }

// Max-heap with capped capacity approach: time complexity of O(nlogk) + O(klogk) = O(nlogk) since k<=n
public class Solution
{
    public int[][] KClosest(int[][] points, int k)
    {
        var maxHeap = new PriorityQueue<int[], double>(
            Comparer<double>.Create((a, b) => b.CompareTo(a)));
        
        for (var i = 0; i < points.Length; i++)
        {
            var p = points[i];
            var distance = Math.Sqrt(Math.Pow(p[0], 2) + Math.Pow(p[1], 2));
            if (i >= k && maxHeap.TryPeek(out var _, out var maxDistance) && distance < maxDistance)
            {
                maxHeap.Dequeue();
            }
            maxHeap.Enqueue(p, distance);
        }

        return [.. maxHeap.UnorderedItems.Select(i => i.Element)];
    }
}