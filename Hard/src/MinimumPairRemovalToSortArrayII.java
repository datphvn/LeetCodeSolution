import java.util.*;

public class MinimumPairRemovalToSortArrayII {

    static class Pair {
        long sum;
        int l, r;
        Pair(long sum, int l, int r) {
            this.sum = sum;
            this.l = l;
            this.r = r;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nums[i];

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] removed = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = (i + 1 < n) ? i + 1 : -1;
        }

        int decreaseCount = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] > a[i + 1]) decreaseCount++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (x, y) -> x.sum != y.sum
                        ? Long.compare(x.sum, y.sum)
                        : Integer.compare(x.l, y.l)
        );

        for (int i = 0; i + 1 < n; i++) {
            pq.add(new Pair(a[i] + a[i + 1], i, i + 1));
        }

        int ops = 0;

        while (decreaseCount > 0) {
            Pair p = pq.poll();
            int i = p.l, j = p.r;

            if (j != next[i] || removed[i] || removed[j]) continue;

            if (a[i] > a[j]) decreaseCount--;
            if (prev[i] != -1 && a[prev[i]] > a[i]) decreaseCount--;
            if (next[j] != -1 && a[j] > a[next[j]]) decreaseCount--;

            a[i] += a[j];
            removed[j] = true;
            next[i] = next[j];
            if (next[j] != -1) prev[next[j]] = i;

            if (prev[i] != -1 && a[prev[i]] > a[i]) decreaseCount++;
            if (next[i] != -1 && a[i] > a[next[i]]) decreaseCount++;

            if (prev[i] != -1)
                pq.add(new Pair(a[prev[i]] + a[i], prev[i], i));
            if (next[i] != -1)
                pq.add(new Pair(a[i] + a[next[i]], i, next[i]));

            ops++;
        }

        return ops;
    }

    public static void main(String[] args) {
        MinimumPairRemovalToSortArrayII solver =
                new MinimumPairRemovalToSortArrayII();

        // Test 1
        int[] nums1 = {5, 2, 3, 1};
        System.out.println(solver.minimumPairRemoval(nums1)); // 2

        // Test 2
        int[] nums2 = {1, 2, 2};
        System.out.println(solver.minimumPairRemoval(nums2)); // 0

        // Test 3
        int[] nums3 = {3, 4, 1, 1, -3, 2, 4, 3};
        System.out.println(solver.minimumPairRemoval(nums3)); // 5
    }
}
