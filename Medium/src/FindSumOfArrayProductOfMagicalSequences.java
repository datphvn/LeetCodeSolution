import java.util.*;

public class FindSumOfArrayProductOfMagicalSequences {
    static final long MOD = 1_000_000_007L;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[m] = modInverse(fact[m]);
        for (int i = m - 1; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;

        long[][] powNums = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            powNums[i][0] = 1;
            long base = (nums[i] % MOD + MOD) % MOD;
            for (int c = 1; c <= m; c++) {
                powNums[i][c] = powNums[i][c - 1] * base % MOD;
            }
        }

        int MAX = m;
        long[][][] dp = new long[m + 1][MAX + 1][MAX + 1];
        long[][][] next = new long[m + 1][MAX + 1][MAX + 1];
        dp[0][0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int t = 0; t <= m; t++)
                for (int carry = 0; carry <= MAX; carry++)
                    Arrays.fill(next[t][carry], 0L);

            for (int t = 0; t <= m; t++) {
                for (int carry = 0; carry <= MAX; carry++) {
                    for (int ones = 0; ones <= m; ones++) {
                        long val = dp[t][carry][ones];
                        if (val == 0) continue;

                        int maxC = m - t;
                        for (int c = 0; c <= maxC; c++) {
                            int nt = t + c;
                            int sum = carry + c;
                            int bit = sum & 1;
                            int ncarry = sum >> 1;
                            int nones = ones + bit;
                            long add = val * powNums[i][c] % MOD;
                            add = add * invFact[c] % MOD;
                            next[nt][ncarry][nones] += add;
                            if (next[nt][ncarry][nones] >= MOD)
                                next[nt][ncarry][nones] -= MOD;
                        }
                    }
                }
            }

            long[][][] tmp = dp;
            dp = next;
            next = tmp;
        }

        long sumWays = 0;
        for (int carry = 0; carry <= MAX; carry++) {
            int carryOnes = Integer.bitCount(carry);
            for (int ones = 0; ones <= m; ones++) {
                if (ones + carryOnes == k) {
                    sumWays += dp[m][carry][ones];
                    if (sumWays >= MOD) sumWays -= MOD;
                }
            }
        }

        long ans = sumWays * fact[m] % MOD;
        return (int) ans;
    }

    private long modPow(long a, long e) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = r * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return r;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    public static void main(String[] args) {
        FindSumOfArrayProductOfMagicalSequences solver = new FindSumOfArrayProductOfMagicalSequences();

        System.out.println(solver.magicalSum(5, 5, new int[]{1, 10, 100, 10000, 1000000})); //  991600007
        System.out.println(solver.magicalSum(2, 2, new int[]{5, 4, 3, 2, 1})); //  170
        System.out.println(solver.magicalSum(1, 1, new int[]{28})); //  28
    }
}
