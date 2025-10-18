import java.util.*;

public class MaximumNumberOfDistinctElementsAfterOperations {

    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        long last = Long.MIN_VALUE;

        for (int num : nums) {
            long start = (long) num - k;
            long end = (long) num + k;

            // Chọn giá trị nhỏ nhất hợp lệ và chưa trùng với giá trị trước đó
            long chosen = Math.max(start, last + 1);

            if (chosen <= end) {
                count++;
                last = chosen;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaximumNumberOfDistinctElementsAfterOperations solver =
                new MaximumNumberOfDistinctElementsAfterOperations();

        // Test 1
        int[] nums1 = {1, 2, 2, 3, 3, 4};
        int k1 = 2;
        System.out.println(solver.maxDistinctElements(nums1, k1)); // ✅ 6

        // Test 2
        int[] nums2 = {4, 4, 4, 4};
        int k2 = 1;
        System.out.println(solver.maxDistinctElements(nums2, k2)); // ✅ 3

        // Test 3
        int[] nums3 = {10, 10, 10};
        int k3 = 0;
        System.out.println(solver.maxDistinctElements(nums3, k3)); // ✅ 1

        // Test 4
        int[] nums4 = {1, 3, 6, 6, 6, 10};
        int k4 = 2;
        System.out.println(solver.maxDistinctElements(nums4, k4)); // ✅ 6
    }
}
