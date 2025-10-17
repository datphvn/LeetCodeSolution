import java.util.*;

public class MaximizeNumberOfPartitionsAfterOperations {

    //đệ quy + bitmask + memo
    private int n, K;
    private Map<Long, Integer> memo;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.n = s.length();
        this.K = k;
        this.memo = new HashMap<>();
        return dfs(s, 0, true, 0) + 1;
    }

    private int dfs(String s, int i, boolean canChange, int mask) {
        if (i == n) return 0;
        long key = ((long)i << 27) | ((canChange ? 1L : 0L) << 26) | (mask & ((1<<26)-1));
        if (memo.containsKey(key)) return memo.get(key);

        int res = Integer.MIN_VALUE;
        int bit = 1 << (s.charAt(i) - 'a');
        res = Math.max(res, getRes(s, i, canChange, mask, bit));
        if (canChange) {
            for (int j = 0; j < 26; ++j) {
                int b = 1 << j;
                res = Math.max(res, getRes(s, i, false, mask, b));
            }
        }
        memo.put(key, res);
        return res;
    }

    private int getRes(String s, int i, boolean nextCanChange, int mask, int newBit) {
        int newMask = mask | newBit;
        if (Integer.bitCount(newMask) > K) {
            return 1 + dfs(s, i + 1, nextCanChange, newBit);
        } else {
            return dfs(s, i + 1, nextCanChange, newMask);
        }
    }

    public static void main(String[] args) {
        MaximizeNumberOfPartitionsAfterOperations solver = new MaximizeNumberOfPartitionsAfterOperations();

        System.out.println(solver.maxPartitionsAfterOperations("accca", 2)); // Expected 3
        System.out.println(solver.maxPartitionsAfterOperations("aabaab", 3)); // Expected 1
        System.out.println(solver.maxPartitionsAfterOperations("xxyz", 1)); // Expected 4

        // stress small
        String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        System.out.println(solver.maxPartitionsAfterOperations(s, 1)); // sanity
    }
}
