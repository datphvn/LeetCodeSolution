import java.util.*;

public class FindAllPossibleStableBinaryArraysI {

    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1000000007;

        long[][][] dp = new long[zero + 1][one + 1][2];

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }

        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        for (int z = 1; z <= zero; z++) {
            for (int o = 1; o <= one; o++) {

                dp[z][o][0] = (dp[z - 1][o][0] + dp[z - 1][o][1]) % MOD;

                if (z - limit - 1 >= 0) {
                    dp[z][o][0] = (dp[z][o][0] - dp[z - limit - 1][o][1] + MOD) % MOD;
                }

                dp[z][o][1] = (dp[z][o - 1][0] + dp[z][o - 1][1]) % MOD;

                if (o - limit - 1 >= 0) {
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }

    public static void main(String[] args) {
        FindAllPossibleStableBinaryArraysI solver = new FindAllPossibleStableBinaryArraysI();

        System.out.println(solver.numberOfStableArrays(1, 1, 2)); // 2
        System.out.println(solver.numberOfStableArrays(1, 2, 1)); // 1
        System.out.println(solver.numberOfStableArrays(3, 3, 2)); // 14
    }
}