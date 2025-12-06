import java.util.*;

public class CountPartitionsWithMaxMinDifferenceAtMostK {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        final long MOD = 1_000_000_007L;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();

        int l = 1;

        for (int i = 1; i <= n; i++) {
            int val = nums[i - 1];

            while (!maxD.isEmpty() && nums[maxD.peekLast() - 1] <= val) maxD.pollLast();
            maxD.addLast(i);

            while (!minD.isEmpty() && nums[minD.peekLast() - 1] >= val) minD.pollLast();
            minD.addLast(i);

            while (!maxD.isEmpty() && !minD.isEmpty()
                    && (long)nums[maxD.peekFirst() - 1] - (long)nums[minD.peekFirst() - 1] > k) {
                if (maxD.peekFirst() == l) maxD.pollFirst();
                if (minD.peekFirst() == l) minD.pollFirst();
                l++;
            }

            if (l - 2 >= 0) {
                dp[i] = (prefix[i - 1] - prefix[l - 2]) % MOD;
                if (dp[i] < 0) dp[i] += MOD;
            } else {
                dp[i] = prefix[i - 1] % MOD;
            }

            prefix[i] = (prefix[i - 1] + dp[i]) % MOD;
        }

        return (int)(dp[n] % MOD);
    }

    public static void main(String[] args) {
        CountPartitionsWithMaxMinDifferenceAtMostK solver =
                new CountPartitionsWithMaxMinDifferenceAtMostK();

        System.out.println(solver.countPartitions(new int[]{9,4,1,3,7}, 4)); // expected 6
        System.out.println(solver.countPartitions(new int[]{3,3,4}, 0));     // expected 2
        System.out.println(solver.countPartitions(new int[]{1,2}, 10));      // expected 2
    }
}
