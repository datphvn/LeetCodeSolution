import java.util.*;

public class CountPartitionsWithEvenSumDifference {

    public int countPartitions(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) total += x;
        return (total % 2 == 0) ? (n - 1) : 0;
    }

    public static void main(String[] args) {
        CountPartitionsWithEvenSumDifference solver = new CountPartitionsWithEvenSumDifference();

        // Test 1
        int[] nums1 = {10,10,3,7,6};
        System.out.println(solver.countPartitions(nums1)); // 4 (expected 4)

        // Test 2
        int[] nums2 = {1,2,2};
        System.out.println(solver.countPartitions(nums2)); // 0

        // Test 3
        int[] nums3 = {2,4,6,8};
        System.out.println(solver.countPartitions(nums3)); // 3
    }
}
