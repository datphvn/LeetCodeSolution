import java.util.*;

public class TakingMaximumEnergyFromTheMysticDungeon {

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i];
            if (i + k < n) dp[i] += dp[i + k];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        TakingMaximumEnergyFromTheMysticDungeon solver = new TakingMaximumEnergyFromTheMysticDungeon();

        // Test case 1
        int[] energy1 = {5, 2, -10, -5, 1};
        int k1 = 3;
        System.out.println(solver.maximumEnergy(energy1, k1)); // ✅ Expected: 3

        // Test case 2
        int[] energy2 = {-2, -3, -1};
        int k2 = 2;
        System.out.println(solver.maximumEnergy(energy2, k2)); // ✅ Expected: -1

        // Test case 3
        int[] energy3 = {10, -5, 6, -2, 3, -1};
        int k3 = 2;
        System.out.println(solver.maximumEnergy(energy3, k3)); // Tự kiểm tra thêm
    }
}
