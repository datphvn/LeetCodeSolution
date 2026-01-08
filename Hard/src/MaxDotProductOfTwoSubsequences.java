public class MaxDotProductOfTwoSubsequences {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int product = nums1[i - 1] * nums2[j - 1];
                dp[i][j] = Math.max(
                        product,
                        Math.max(
                                dp[i - 1][j - 1] + product,
                                Math.max(dp[i - 1][j], dp[i][j - 1])
                        )
                );
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        MaxDotProductOfTwoSubsequences solver = new MaxDotProductOfTwoSubsequences();

        // Test 1
        int[] nums1_1 = {2, 1, -2, 5};
        int[] nums2_1 = {3, 0, -6};
        System.out.println(solver.maxDotProduct(nums1_1, nums2_1)); // 18

        // Test 2
        int[] nums1_2 = {3, -2};
        int[] nums2_2 = {2, -6, 7};
        System.out.println(solver.maxDotProduct(nums1_2, nums2_2)); // 21

        // Test 3
        int[] nums1_3 = {-1, -1};
        int[] nums2_3 = {1, 1};
        System.out.println(solver.maxDotProduct(nums1_3, nums2_3)); // -1
    }
}
