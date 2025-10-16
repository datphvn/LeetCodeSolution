import java.util.*;

public class SmallestMissingNonNegativeIntegerAfterOperations {
    //đồng dư
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for (int x : nums) {
            int r = ((x % value) + value) % value; // xử lý âm
            cnt[r]++;
        }

        int mex = 0;
        while (true) {
            int r = mex % value;
            if (cnt[r] == 0) break;
            cnt[r]--;
            mex++;
        }

        return mex;
    }

    public static void main(String[] args) {
        SmallestMissingNonNegativeIntegerAfterOperations solver =
                new SmallestMissingNonNegativeIntegerAfterOperations();

        // Test 1
        int[] nums1 = {1, -10, 7, 13, 6, 8};
        int value1 = 5;
        System.out.println(solver.findSmallestInteger(nums1, value1)); // Expected 4

        // Test 2
        int[] nums2 = {1, -10, 7, 13, 6, 8};
        int value2 = 7;
        System.out.println(solver.findSmallestInteger(nums2, value2)); // Expected 2

        // Test 3: tất cả số âm
        int[] nums3 = {-1, -2, -3, -4};
        int value3 = 3;
        System.out.println(solver.findSmallestInteger(nums3, value3)); // Expected 3

        // Test 4: tất cả phần dư đủ 0..value-1
        int[] nums4 = {0, 1, 2, 3, 4};
        int value4 = 5;
        System.out.println(solver.findSmallestInteger(nums4, value4)); // Expected 5
    }
}
