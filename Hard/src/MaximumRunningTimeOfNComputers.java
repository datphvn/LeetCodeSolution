import java.util.*;

public class MaximumRunningTimeOfNComputers {

    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 1, right = sum / n, ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canRun(mid, n, batteries)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canRun(long T, int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, T);
            if (total >= (long)n * T) return true;
        }
        return total >= (long)n * T;
    }

    public static void main(String[] args) {
        MaximumRunningTimeOfNComputers solver = new MaximumRunningTimeOfNComputers();

        // Test 1
        int n1 = 2;
        int[] batteries1 = {3, 3, 3};
        System.out.println(solver.maxRunTime(n1, batteries1)); // 4

        // Test 2
        int n2 = 2;
        int[] batteries2 = {1, 1, 1, 1};
        System.out.println(solver.maxRunTime(n2, batteries2)); // 2

        // Test 3
        int n3 = 3;
        int[] batteries3 = {10, 10, 3, 5};
        System.out.println(solver.maxRunTime(n3, batteries3)); // 7
    }
}
