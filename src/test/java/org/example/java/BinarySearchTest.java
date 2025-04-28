package org.example.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private final BinarySearch _search = new BinarySearch();

    @Test
    public void shouldReturnIndexIfFound() {
        int[] sortedArrOddLen = new int[] {-10, -5, 0, 2, 3, 7, 10};
        assertEquals(0, _search.find(sortedArrOddLen, -10));
        assertEquals(1, _search.find(sortedArrOddLen, -5));
        assertEquals(2, _search.find(sortedArrOddLen, 0));
        assertEquals(3, _search.find(sortedArrOddLen, 2));
        assertEquals(4, _search.find(sortedArrOddLen, 3));
        assertEquals(5, _search.find(sortedArrOddLen, 7));
        assertEquals(6, _search.find(sortedArrOddLen, 10));

        int[] sortedArrEvenLen = new int[] {-10, -5, 0, 2, 3, 7};
        assertEquals(0, _search.find(sortedArrEvenLen, -10));
        assertEquals(1, _search.find(sortedArrEvenLen, -5));
        assertEquals(2, _search.find(sortedArrEvenLen, 0));
        assertEquals(3, _search.find(sortedArrEvenLen, 2));
        assertEquals(4, _search.find(sortedArrEvenLen, 3));
        assertEquals(5, _search.find(sortedArrEvenLen, 7));
    }

    @Test
    public void shouldReturnNegativeOneIfNotFound() {
        int[] sortedArr = new int[] {-10, -5, 0, 2, 3, 7, 10};
        assertEquals(-1, _search.find(sortedArr, -1));
        assertEquals(-1, _search.find(sortedArr, 4));
    }
}