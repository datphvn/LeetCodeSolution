public class ChampagneTower799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double overflow = (dp[i][j] - 1) / 2.0;
                    dp[i+1][j] += overflow;
                    dp[i+1][j+1] += overflow;
                    dp[i][j] = 1;
                }
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }

    public static void main(String[] args) {
        ChampagneTower799 solver = new ChampagneTower799();

        // Example 1
        System.out.println(
                solver.champagneTower(1, 1, 1)
        ); // 0.0

        // Example 2
        System.out.println(
                solver.champagneTower(2, 1, 1)
        ); // 0.5

        // Example 3
        System.out.println(
                solver.champagneTower(100000009, 33, 17)
        ); // 1.0

        // Additional test
        System.out.println(
                solver.champagneTower(4, 2, 1)
        ); // 0.5
    }
}
