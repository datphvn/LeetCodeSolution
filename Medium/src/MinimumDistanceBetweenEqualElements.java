import java.util.*;

public class MinimumDistanceBetweenEqualElements {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            map.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }

        int result = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;

            for (int i = 0; i <= list.size() - 3; i++) {
                int a = list.get(i);
                int c = list.get(i + 2);
                int sum = 2 * (c - a);
                result = Math.min(result, sum);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenEqualElements solver = new MinimumDistanceBetweenEqualElements();

        // Test 1
        int[] nums1 = {1, 2, 1, 1, 3};
        System.out.println(solver.minimumDistance(nums1)); // 4

        // Test 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solver.minimumDistance(nums2)); // -1

        // Test 3
        int[] nums3 = {5, 5, 5, 5};
        System.out.println(solver.minimumDistance(nums3)); // 4
    }
}