import java.util.*;

public class MaximumFrequencyAfterOperationsI {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        TreeMap<Long, Integer> events = new TreeMap<>();
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            long L = (long)x - k;
            long R = (long)x + k;
            events.put(L, events.getOrDefault(L, 0) + 1);
            events.put(R + 1, events.getOrDefault(R + 1, 0) - 1);
            // add nums value as a key so we evaluate candidate at that exact point
            events.put((long)x, events.getOrDefault((long)x, 0) + 0);
            freq.put((long)x, freq.getOrDefault((long)x, 0) + 1);
        }

        int ans = 1;
        int cur = 0;
        for (Map.Entry<Long, Integer> e : events.entrySet()) {
            long pos = e.getKey();
            cur += e.getValue();
            if (cur <= 0) continue;
            int freqAtPos = freq.getOrDefault(pos, 0);
            int candidate = Math.min(cur, freqAtPos + numOperations);
            ans = Math.max(ans, candidate);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumFrequencyAfterOperationsI solver = new MaximumFrequencyAfterOperationsI();

        int[] a1 = {1, 4, 5};
        System.out.println(solver.maxFrequency(a1, 1, 2)); // 2

        int[] a2 = {5, 11, 20, 20};
        System.out.println(solver.maxFrequency(a2, 5, 1)); // 2 (fixed)

        int[] fail1 = {1, 90};
        System.out.println(solver.maxFrequency(fail1, 76, 1)); // 1

        int[] fail2 = {88, 53};
        System.out.println(solver.maxFrequency(fail2, 27, 2)); // 2

        // extra
        int[] a3 = {1,1,2,2,3};
        System.out.println(solver.maxFrequency(a3, 1, 2)); // check
    }
}
