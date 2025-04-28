package org.example.java;

import org.jetbrains.annotations.Nullable;

public class LinkedList {
    public static class Node<T> {
        public @Nullable Node<T> next = null;
        public @Nullable Node<T> prev = null;
        public T data;

        public Node(T d) {
            data = d;
        }
    }

    public static <T> Node<T> append(Node<T> head, T d) {
        Node<T> nextNode = new Node<>(d);
        Node<T> currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = nextNode;
        nextNode.prev = currNode;

        return head;
    }

    public static <T> Node<T> delete(Node<T> head, T d) {
        if (head.data == d) {
            head = head.next;
            head.prev = null;
            return head;
        }

        Node<T> currNode = head.next;
        while (currNode != null) {
            if (currNode.data == d) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
            }
            currNode = currNode.next;
        }
        return head;
    }
}
