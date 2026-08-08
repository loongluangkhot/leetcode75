package org.example.leetcode.LinkedList;

import org.example.leetcode.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        var oddHead = head;
        var currOdd = oddHead;
        var evenHead = head != null ? head.next : null;
        var currEven = evenHead;
        var curr = evenHead != null ? evenHead.next : null;
        var isOdd = true;
        while (curr != null) {
            if (isOdd) {
                currOdd.next = curr;
                currOdd = curr;
            } else {
                currEven.next = curr;
                currEven = curr;
            }

            curr = curr.next;
            isOdd = !isOdd;
        }
        if (currOdd != null) {
            currOdd.next = evenHead;
        }
        if (currEven != null) {
            currEven.next = null;
        }
        return oddHead;
    }
}
