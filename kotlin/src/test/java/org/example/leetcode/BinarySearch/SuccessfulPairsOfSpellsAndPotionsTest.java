package org.example.leetcode.BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuccessfulPairsOfSpellsAndPotionsTest {

    @Test
    public void shouldReturnCorrectlyWhenPotionsIsLongerThanSpells() {
        var spells = new int[] {5,1,3};
        var potions = new int[] {1,2,3,4,5};
        var svc = new SuccessfulPairsOfSpellsAndPotions();

        var result = svc.successfulPairs(spells, potions, 7);

        var expectedResult = new int[] {4,0,3};
        assertArrayEquals(expectedResult, result);
    }
}