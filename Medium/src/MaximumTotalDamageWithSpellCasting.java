import java.util.*;

public class MaximumTotalDamageWithSpellCasting {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) map.put(p, map.getOrDefault(p, 0L) + (long) p);

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        int u = keyList.size();
        if (u == 0) return 0L;

        int[] keys = new int[u];
        long[] total = new long[u];
        for (int i = 0; i < u; i++) {
            keys[i] = keyList.get(i);
            total[i] = map.get(keys[i]);
        }

        long[] dp = new long[u];
        dp[0] = total[0];
        for (int i = 1; i < u; i++) {
            int j = findPrevLE(keys, keys[i] - 3);
            long include = total[i] + (j >= 0 ? dp[j] : 0L);
            long exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }

        return dp[u - 1];
    }

    private int findPrevLE(int[] keys, int value) {
        int l = 0, r = keys.length - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (keys[mid] <= value) { ans = mid; l = mid + 1; }
            else r = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting solver = new MaximumTotalDamageWithSpellCasting();

        int[] power1 = {1,1,3,4};
        System.out.println(solver.maximumTotalDamage(power1)); // Expected 6

        int[] power2 = {7,1,6,6};
        System.out.println(solver.maximumTotalDamage(power2)); // Expected 13

        int[] power3 = {1,2,3,6,8,9};
        System.out.println(solver.maximumTotalDamage(power3)); // thêm test
    }
}
