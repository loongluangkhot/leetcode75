#!/usr/bin/env dotnet
// https://leetcode.com/problems/linked-list-cycle/description/

// Definition for singly-linked list.
public class ListNode
{
    public int val;
    public ListNode? next;

    public ListNode(int x)
    {
        val = x;
        next = null;
    }
}

public class Solution
{
    public bool HasCycle(ListNode head)
    {
        var curr = head;
        var seen = new HashSet<ListNode>();

        while (curr != null)
        {
            if (seen.Contains(curr))
            {
                return true;
            }

            seen.Add(curr);
            curr = curr.next;
        }

        return false;
    }
}
