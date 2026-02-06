import java.util.*;

public class MinimumRemovalsToBalanceArray {

    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxLen = 1;
        int l = 0;

        for (int r = 0; r < n; r++) {
            while ((long) nums[r] > (long) nums[l] * k) {
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return n - maxLen;
    }

    public static void main(String[] args) {
        MinimumRemovalsToBalanceArray solver = new MinimumRemovalsToBalanceArray();

        int[] nums1 = {2, 1, 5};
        System.out.println(solver.minRemoval(nums1, 2)); // 1

        int[] nums2 = {1, 6, 2, 9};
        System.out.println(solver.minRemoval(nums2, 3)); // 2

        int[] nums3 = {4, 6};
        System.out.println(solver.minRemoval(nums3, 2)); // 0

        int[] nums4 = {10};
        System.out.println(solver.minRemoval(nums4, 5)); // 0
    }
}
