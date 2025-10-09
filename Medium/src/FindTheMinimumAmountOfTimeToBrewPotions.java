import java.util.*;

public class FindTheMinimumAmountOfTimeToBrewPotions {
    //dùng quy hoạch động cho bài này
    public long minTimeToBrew(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[][] dp = new long[n][m];
        dp[0][0] = (long) skill[0] * mana[0];

        // Wizard 0 làm hết các potion
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + (long) skill[0] * mana[j];
        }

        // Potion 0 qua hết các wizard
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (long) skill[i] * mana[0];
        }

        // Các ô còn lại
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + (long) skill[i] * mana[j];
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        FindTheMinimumAmountOfTimeToBrewPotions solver = new FindTheMinimumAmountOfTimeToBrewPotions();

        // Test 1
        int[] skill1 = {1, 5, 2, 4};
        int[] mana1 = {5, 1, 4, 2};
        System.out.println(solver.minTimeToBrew(skill1, mana1)); // 110

        // Test 2
        int[] skill2 = {1, 1, 1};
        int[] mana2 = {1, 1, 1};
        System.out.println(solver.minTimeToBrew(skill2, mana2)); // 5

        // Test 3
        int[] skill3 = {1, 2, 3, 4};
        int[] mana3 = {1, 2};
        System.out.println(solver.minTimeToBrew(skill3, mana3)); // 21
    }
}
