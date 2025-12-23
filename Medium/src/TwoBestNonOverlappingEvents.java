import java.util.*;

public class TwoBestNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;
        int[] maxSuffix = new int[n];

        maxSuffix[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, events[i][2]);

            int next = binarySearch(events, events[i][1] + 1);
            if (next < n) {
                ans = Math.max(ans, events[i][2] + maxSuffix[next]);
            }
        }

        return ans;
    }

    private int binarySearch(int[][] events, int target) {
        int l = 0, r = events.length - 1;
        int res = events.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoBestNonOverlappingEvents solver = new TwoBestNonOverlappingEvents();

        // Test 1
        int[][] events1 = {{1,3,2},{4,5,2},{2,4,3}};
        System.out.println(solver.maxTwoEvents(events1)); // 4

        // Test 2
        int[][] events2 = {{1,3,2},{4,5,2},{1,5,5}};
        System.out.println(solver.maxTwoEvents(events2)); // 5

        // Test 3
        int[][] events3 = {{1,5,3},{1,5,1},{6,6,5}};
        System.out.println(solver.maxTwoEvents(events3)); // 8
    }
}
