package org.example.leetcode.LinkedList;

import org.example.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenLinkedListTest {
    OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

    @Test
    void shouldReturnOddBeforeEven() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenLinkedList.oddEvenList(head);

        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(5, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
    }

    @Test
    void shouldReturnNullIfInputIsEmpty() {
        ListNode result = oddEvenLinkedList.oddEvenList(null);
        assertNull(result);
    }
}