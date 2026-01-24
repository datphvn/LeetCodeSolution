import java.util.*;

public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxPairSum = 0;

        for (int i = 0; i < n / 2; i++) {
            int pairSum = nums[i] + nums[n - 1 - i];
            maxPairSum = Math.max(maxPairSum, pairSum);
        }

        return maxPairSum;
    }

    public static void main(String[] args) {
        MinimizeMaximumPairSumInArray solver = new MinimizeMaximumPairSumInArray();

        // Test 1
        int[] nums1 = {3, 5, 2, 3};
        System.out.println(solver.minPairSum(nums1)); // 7

        // Test 2
        int[] nums2 = {3, 5, 4, 2, 4, 6};
        System.out.println(solver.minPairSum(nums2)); // 8

        // Test 3
        int[] nums3 = {1, 1, 1, 1};
        System.out.println(solver.minPairSum(nums3)); // 2
    }
}
