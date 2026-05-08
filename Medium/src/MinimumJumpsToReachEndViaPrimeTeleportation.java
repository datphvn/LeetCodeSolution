import java.util.*;

public class MinimumJumpsToReachEndViaPrimeTeleportation {

    static final int LIMIT = 1000005;
    static boolean[] notPrime = new boolean[LIMIT];

    static {
        notPrime[0] = true;
        notPrime[1] = true;

        for (int i = 2; i * i < LIMIT; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < LIMIT; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;

        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int[] head = new int[maxValue + 1];
        Arrays.fill(head, -1);

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = head[nums[i]];
            head[nums[i]] = i;
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        dist[0] = 0;

        Set<Integer> usedPrime = new HashSet<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == n - 1) {
                return dist[current];
            }

            int left = current - 1;
            int right = current + 1;

            if (left >= 0 && dist[left] == -1) {
                dist[left] = dist[current] + 1;
                queue.offer(left);
            }

            if (right < n && dist[right] == -1) {
                dist[right] = dist[current] + 1;
                queue.offer(right);
            }

            int value = nums[current];

            if (!notPrime[value] && !usedPrime.contains(value)) {
                usedPrime.add(value);

                for (int multiple = value; multiple <= maxValue; multiple += value) {

                    for (int index = head[multiple];
                         index != -1;
                         index = next[index]) {

                        if (dist[index] == -1) {
                            dist[index] = dist[current] + 1;
                            queue.offer(index);
                        }
                    }

                    head[multiple] = -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumJumpsToReachEndViaPrimeTeleportation solver =
                new MinimumJumpsToReachEndViaPrimeTeleportation();

        // Test 1
        int[] nums1 = {1, 2, 4, 6};
        System.out.println(solver.minJumps(nums1)); // 2

        // Test 2
        int[] nums2 = {2, 3, 4, 7, 9};
        System.out.println(solver.minJumps(nums2)); // 2

        // Test 3
        int[] nums3 = {4, 6, 5, 8};
        System.out.println(solver.minJumps(nums3)); // 3

        // Test 4
        int[] nums4 = {2, 4, 8, 16, 32};
        System.out.println(solver.minJumps(nums4)); // 1

        // Test 5
        int[] nums5 = {1};
        System.out.println(solver.minJumps(nums5)); // 0
    }
}