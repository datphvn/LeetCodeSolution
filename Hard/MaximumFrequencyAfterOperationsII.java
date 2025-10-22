import java.util.*;

public class MaximumFrequencyAfterOperationsII {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        TreeMap<Long, Integer> events = new TreeMap<>();
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            long L = (long)x - k;
            long R = (long)x + k;
            events.put(L, events.getOrDefault(L, 0) + 1);
            events.put(R + 1, events.getOrDefault(R + 1, 0) - 1);
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
        MaximumFrequencyAfterOperationsII solver = new MaximumFrequencyAfterOperationsII();

        System.out.println(solver.maxFrequency(new int[]{1,4,5}, 1, 2)); // 2
        System.out.println(solver.maxFrequency(new int[]{5,11,20,20}, 5, 1)); // 2
        System.out.println(solver.maxFrequency(new int[]{1,90}, 76, 1)); // 1
        System.out.println(solver.maxFrequency(new int[]{88,53}, 27, 2)); // 2
        System.out.println(solver.maxFrequency(new int[]{1,2,3,1000000000}, 1, 1)); // 3
    }
}
