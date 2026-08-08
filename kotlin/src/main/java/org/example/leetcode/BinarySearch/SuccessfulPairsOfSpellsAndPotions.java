package org.example.leetcode.BinarySearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.stream.IntStream;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        var sortedSpells = IntStream.of(spells).distinct().boxed().sorted(Collections.reverseOrder()).toList();
        var sortedPotions = IntStream.of(potions).sorted().boxed().toList();
        int i = 0;
        int j = 0;
        var cntMap = new HashMap<Integer, Integer>();
        while(i < sortedSpells.size()) {
            int spell = sortedSpells.get(i);
            while(j < potions.length && (long)spell * sortedPotions.get(j) < success) {
                j++;
            }
            int numPotions = potions.length - j;
            cntMap.put(spell, numPotions);
            i++;
        }

        return IntStream.of(spells).map(cntMap::get).toArray();
    }
}
