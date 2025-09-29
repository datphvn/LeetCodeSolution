public class MinimumScoreTriangulation {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]
                    );
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        MinimumScoreTriangulation solver = new MinimumScoreTriangulation();

        int[] v1 = {1, 2, 3};
        System.out.println(solver.minScoreTriangulation(v1)); // 6

        int[] v2 = {3, 7, 4, 5};
        System.out.println(solver.minScoreTriangulation(v2)); // 144

        int[] v3 = {1, 3, 1, 4, 1, 5};
        System.out.println(solver.minScoreTriangulation(v3)); // 13
    }
}
