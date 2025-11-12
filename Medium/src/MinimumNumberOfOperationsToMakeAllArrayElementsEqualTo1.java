import java.util.*;

public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

    public int minOperations(int[] nums) {
        int n = nums.length;
        int totalGcd = nums[0];

        // GCD toàn mảng
        for (int i = 1; i < n; i++) {
            totalGcd = gcd(totalGcd, nums[i]);
        }
        if (totalGcd > 1) return -1;

        // Nếu có sẵn số 1
        int ones = 0;
        for (int x : nums) if (x == 1) ones++;
        if (ones > 0) return n - ones;

        // Tìm đoạn nhỏ nhất có gcd = 1
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curGcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                curGcd = gcd(curGcd, nums[j]);
                if (curGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : (n + minLen - 2);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 solver = new MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1();

        // Test 1
        int[] nums1 = {2, 6, 3, 4};
        System.out.println(solver.minOperations(nums1)); // 4

        // Test 2
        int[] nums2 = {2, 10, 6, 14};
        System.out.println(solver.minOperations(nums2)); // -1

        // Test 3
        int[] nums3 = {1, 2, 3};
        System.out.println(solver.minOperations(nums3)); // 2

        // Test 4
        int[] nums4 = {4, 6, 9, 3};
        System.out.println(solver.minOperations(nums4)); // 5
    }
}
