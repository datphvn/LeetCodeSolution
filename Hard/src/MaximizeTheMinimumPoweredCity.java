import java.util.*;

public class MaximizeTheMinimumPoweredCity {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stations[i];

        long left = 0, right = (long)1e18, ans = 0;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (canAchieve(mid, stations, r, k, prefix)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(long target, int[] stations, int r, long k, long[] prefix) {
        int n = stations.length;
        long[] diff = new long[n + 1];
        long currAdd = 0;
        long used = 0;

        for (int i = 0; i < n; i++) {
            currAdd += diff[i];

            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            long base = prefix[R + 1] - prefix[L];

            long cur = base + currAdd;
            if (cur < target) {
                long need = target - cur;
                used += need;
                if (used > k) return false;
                currAdd += need;
                int expire = Math.min(n, i + 2 * r + 1);
                diff[expire] -= need;
            }
        }
        return true;
    }

    // ---------- MAIN TEST ----------
    public static void main(String[] args) {
        MaximizeTheMinimumPoweredCity solver = new MaximizeTheMinimumPoweredCity();

        int[] stations1 = {1, 2, 4, 5, 0};
        System.out.println(solver.maxPower(stations1, 1, 2)); // Expected: 5

        int[] stations2 = {4, 4, 4, 4};
        System.out.println(solver.maxPower(stations2, 0, 3)); // Expected: 4
    }
}
