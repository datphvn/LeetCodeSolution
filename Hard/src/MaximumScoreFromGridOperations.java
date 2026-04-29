import java.util.*;

public class MaximumScoreFromGridOperations {

    public long maximumScore(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        if (m == 1) return 0;

        long[][] col = new long[m][n + 1];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                col[j][i + 1] = col[j][i] + grid[i][j];
            }
        }

        long[][] dp = new long[n + 1][n + 1];
        long[][] prefMax = new long[n + 1][n + 1];
        long[][] suffMax = new long[n + 1][n + 1];

        for (int c = 1; c < m; c++) {

            long[][] newdp = new long[n + 1][n + 1];

            for (int curr = 0; curr <= n; curr++) {
                for (int prev = 0; prev <= n; prev++) {

                    if (curr <= prev) {
                        long gain = col[c][prev] - col[c][curr];
                        newdp[curr][prev] = Math.max(
                                newdp[curr][prev],
                                suffMax[prev][0] + gain
                        );
                    } else {
                        long gain = col[c - 1][curr] - col[c - 1][prev];
                        newdp[curr][prev] = Math.max(
                                newdp[curr][prev],
                                Math.max(
                                        suffMax[prev][curr],
                                        prefMax[prev][curr] + gain
                                )
                        );
                    }
                }
            }

            for (int curr = 0; curr <= n; curr++) {

                prefMax[curr][0] = newdp[curr][0];

                for (int prev = 1; prev <= n; prev++) {

                    long penalty = 0;
                    if (prev > curr)
                        penalty = col[c][prev] - col[c][curr];

                    prefMax[curr][prev] = Math.max(
                            prefMax[curr][prev - 1],
                            newdp[curr][prev] - penalty
                    );
                }

                suffMax[curr][n] = newdp[curr][n];

                for (int prev = n - 1; prev >= 0; prev--) {
                    suffMax[curr][prev] = Math.max(
                            suffMax[curr][prev + 1],
                            newdp[curr][prev]
                    );
                }
            }

            dp = newdp;
        }

        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, Math.max(dp[0][k], dp[n][k]));
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumScoreFromGridOperations solver = new MaximumScoreFromGridOperations();

        int[][] grid1 = {
                {0,0,0,0,0},
                {0,0,3,0,0},
                {0,1,0,0,0},
                {5,0,0,3,0},
                {0,0,0,0,2}
        };
        System.out.println(solver.maximumScore(grid1)); // 11

        int[][] grid2 = {
                {10,9,0,0,15},
                {7,1,0,8,0},
                {5,20,0,11,0},
                {0,0,0,1,2},
                {8,12,1,10,3}
        };
        System.out.println(solver.maximumScore(grid2)); // 94
    }
}