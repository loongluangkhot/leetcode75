package org.example.leetcode.LinkedList;

import org.example.leetcode.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {
//    // Solution 1
//    public ListNode deleteMiddle(ListNode head) {
//        int len = 0;
//        ListNode curr = head;
//        while(curr != null) {
//            len++;
//            curr = curr.next;
//        }
//        int mid = len / 2;
//
//        curr = head;
//        ListNode prev = null;
//        for(int i = 0; i < mid; i++) {
//            prev = curr;
//            curr = curr.next;
//        }
//
//        if(prev != null) {
//            prev.next = curr.next;
//            return head;
//        }
//
//        return null;
//    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode beforeMid = null;
        ListNode mid = head;
        ListNode curr = head;
        int len = 1;
        while(curr.next != null) {
            curr = curr.next;
            len++;
            if(len % 2 == 0) {
                beforeMid = mid;
                mid = mid.next;
            }
        }

        if(beforeMid == null) {
            return null;
        }

        beforeMid.next = mid.next;
        return head;
    }
}
