import java.util.*;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenHighestAndLowestOfKScores solver =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();

        // Test 1: nums = [90], k = 1 -> 0
        int[] nums1 = {90};
        System.out.println(solver.minimumDifference(nums1, 1)); // 0

        // Test 2: nums = [9,4,1,7], k = 2 -> 2
        int[] nums2 = {9, 4, 1, 7};
        System.out.println(solver.minimumDifference(nums2, 2)); // 2

        // Test 3: nums = [1,5,8,10], k = 3 -> 5
        int[] nums3 = {1, 5, 8, 10};
        System.out.println(solver.minimumDifference(nums3, 3)); // 5
    }
}
