import java.util.*;

public class SuccessfulPairsOfSpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            int left = 0, right = m - 1, idx = m;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (spell * potions[mid] >= success) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            res[i] = m - idx;
        }

        return res;
    }

    public static void main(String[] args) {
        SuccessfulPairsOfSpellsAndPotions solver = new SuccessfulPairsOfSpellsAndPotions();

        // Test 1
        int[] spells1 = {5, 1, 3};
        int[] potions1 = {1, 2, 3, 4, 5};
        long success1 = 7;
        System.out.println(Arrays.toString(solver.successfulPairs(spells1, potions1, success1)));
        // [4, 0, 3]

        // Test 2
        int[] spells2 = {3, 1, 2};
        int[] potions2 = {8, 5, 8};
        long success2 = 16;
        System.out.println(Arrays.toString(solver.successfulPairs(spells2, potions2, success2)));
        // [2, 0, 2]

        // Test 3 (biên)
        int[] spells3 = {1, 2, 3};
        int[] potions3 = {1, 1, 1};
        long success3 = 5;
        System.out.println(Arrays.toString(solver.successfulPairs(spells3, potions3, success3)));
        // [0, 0, 0]
    }
}
