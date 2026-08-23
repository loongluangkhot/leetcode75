#!/usr/bin/env dotnet
// https://leetcode.com/problems/reverse-linked-list/description/

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode? next;
    public ListNode(int val=0, ListNode? next=null) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode? ReverseList(ListNode? head) {
        if (head == null) return head;
        var stack = new Stack<ListNode>();
        var curr = head;
        while (curr != null)
        {
            stack.Push(curr);
            curr = curr.next;
        }
        
        var result = stack.Pop();
        curr = result;
        while (stack.Count() > 0)
        {
            var next = stack.Pop();
            curr.next = next;
            curr = next;
        }
        curr.next = null;

        return result;
    }
}