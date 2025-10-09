import java.util.*;

public class FindMinimumAmountOfTimeToBrewPotions {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        if (n == 0 || m == 0) return 0L;

        long start = 0L;
        long[] prefPrev = new long[n];
        long[] prefCurrStart = new long[n];

        for (int j = 1; j < m; j++) {
            prefPrev[0] = (long) skill[0] * mana[j - 1];
            for (int i = 1; i < n; i++) prefPrev[i] = prefPrev[i - 1] + (long) skill[i] * mana[j - 1];

            prefCurrStart[0] = 0L;
            for (int i = 1; i < n; i++) prefCurrStart[i] = prefCurrStart[i - 1] + (long) skill[i - 1] * mana[j];

            long maxA = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long A = prefPrev[i] - prefCurrStart[i];
                if (A > maxA) maxA = A;
            }
            start += maxA;
        }

        long totalLast = 0L;
        for (int i = 0; i < n; i++) totalLast += (long) skill[i] * mana[m - 1];
        return start + totalLast;
    }

    public static void main(String[] args) {
        FindMinimumAmountOfTimeToBrewPotions solver = new FindMinimumAmountOfTimeToBrewPotions();

        int[] skill1 = {1, 5, 2, 4};
        int[] mana1  = {5, 1, 4, 2};
        System.out.println(solver.minTime(skill1, mana1)); // 110

        int[] skill2 = {1,1,1};
        int[] mana2  = {1,1,1};
        System.out.println(solver.minTime(skill2, mana2)); // 5

        int[] skill3 = {1,2,3,4};
        int[] mana3  = {1,2};
        System.out.println(solver.minTime(skill3, mana3)); // 21
    }
}
