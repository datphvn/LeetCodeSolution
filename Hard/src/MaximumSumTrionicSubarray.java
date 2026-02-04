public class MaximumSumTrionicSubarray {

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int j = i;

            long sum1 = nums[j];
            while (j + 1 < n && nums[j] < nums[j + 1]) {
                j++;
                sum1 += nums[j];
            }
            if (j == i) continue;

            int p = j;

            long sum2 = 0;
            while (j + 1 < n && nums[j] > nums[j + 1]) {
                j++;
                sum2 += nums[j];
            }
            if (j == p) continue;

            int q = j;

            long sum3 = 0;
            while (j + 1 < n && nums[j] < nums[j + 1]) {
                j++;
                sum3 += nums[j];
            }
            if (j == q) continue;

            long total = sum1 + sum2 + sum3;
            ans = Math.max(ans, total);

            i = p;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        MaximumSumTrionicSubarray solver = new MaximumSumTrionicSubarray();

        int[] test1 = {1, 4, 2, 2, 3, 1, 2};
        System.out.println(solver.maxSumTrionic(test1)); // 8

        int[] test2 = {1, 2, 3, 2, 1, 2, 3};
        System.out.println(solver.maxSumTrionic(test2)); // 14

        int[] test3 = {1, 2, 3};
        System.out.println(solver.maxSumTrionic(test3)); // 0
    }
}
