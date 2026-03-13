import java.util.*;

public class MinimumNumberOfSecondsToMakeMountainHeightZero {

    public long minNumberOfSeconds(int height, int[] times) {
        long lo = 1, hi = 10000000000000000L;

        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            long tot = 0;

            for (int i = 0; i < times.length && tot < height; i++) {
                tot += (long)(Math.sqrt((double) mid / times[i] * 2 + 0.25) - 0.5);
            }

            if (tot >= height)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    public static void main(String[] args) {
        MinimumNumberOfSecondsToMakeMountainHeightZero solver =
                new MinimumNumberOfSecondsToMakeMountainHeightZero();

        // Test 1
        int height1 = 4;
        int[] times1 = {2,1,1};
        System.out.println(solver.minNumberOfSeconds(height1, times1)); // 3

        // Test 2
        int height2 = 10;
        int[] times2 = {3,2,2,4};
        System.out.println(solver.minNumberOfSeconds(height2, times2)); // 12

        // Test 3
        int height3 = 5;
        int[] times3 = {1};
        System.out.println(solver.minNumberOfSeconds(height3, times3)); // 15
    }
}