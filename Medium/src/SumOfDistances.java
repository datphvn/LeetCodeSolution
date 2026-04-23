import java.util.*;

public class SumOfDistances {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> pos : mp.values()) {

            long sum = 0;
            for (int x : pos) sum += x;

            long leftSum = 0;
            int m = pos.size();

            for (int i = 0; i < m; i++) {
                long rightSum = sum - leftSum - pos.get(i);

                long left  = (long) pos.get(i) * i - leftSum;
                long right = rightSum - (long) pos.get(i) * (m - i - 1);

                ans[pos.get(i)] = left + right;

                leftSum += pos.get(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SumOfDistances solver = new SumOfDistances();

        // Test 1
        int[] nums1 = {1,3,1,1,2};
        System.out.println(Arrays.toString(solver.distance(nums1)));
        // [5,0,3,4,0]

        // Test 2
        int[] nums2 = {0,5,3};
        System.out.println(Arrays.toString(solver.distance(nums2)));
        // [0,0,0]

        // Test 3
        int[] nums3 = {2,2,2};
        System.out.println(Arrays.toString(solver.distance(nums3)));
        // [3,2,3]
    }
}