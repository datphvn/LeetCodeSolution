import java.util.*;

public class MaximumSubarraySumWithLengthDivisibleByK {

    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);

        long prefix = 0;
        long result = Long.MIN_VALUE;

        minPrefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            int mod = (i + 1) % k;

            if (minPrefix[mod] != Long.MAX_VALUE) {
                result = Math.max(result, prefix - minPrefix[mod]);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSubarraySumWithLengthDivisibleByK solver =
                new MaximumSubarraySumWithLengthDivisibleByK();

        // Test 1
        System.out.println(solver.maxSubarraySum(new int[]{1,2}, 1)); // 3

        // Test 2
        System.out.println(solver.maxSubarraySum(new int[]{-1,-2,-3,-4,-5}, 4)); // -10

        // Test 3
        System.out.println(solver.maxSubarraySum(new int[]{-5,1,2,-3,4}, 2)); // 4
    }
}
