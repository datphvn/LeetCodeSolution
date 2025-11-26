import java.util.*;

public class PathsInMatrixWhoseSumIsDivisibleByK {
    static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][k];

        for (int i = 0; i < m; i++) {
            int[][] newDp = new int[n][k];
            for (int j = 0; j < n; j++) {
                int val = grid[i][j] % k;
                if (i == 0 && j == 0) {
                    newDp[0][val] = 1;
                    continue;
                }
                if (i > 0) {
                    for (int r = 0; r < k; r++) {
                        int cnt = dp[j][r];
                        if (cnt == 0) continue;
                        int newR = (r + val) % k;
                        newDp[j][newR] = (int)((newDp[j][newR] + (long)cnt) % MOD);
                    }
                }
                if (j > 0) {
                    for (int r = 0; r < k; r++) {
                        int cnt = newDp[j - 1][r];
                        if (cnt == 0) continue;
                        int newR = (r + val) % k;
                        newDp[j][newR] = (int)((newDp[j][newR] + (long)cnt) % MOD);
                    }
                }
            }
            dp = newDp;
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        PathsInMatrixWhoseSumIsDivisibleByK solver = new PathsInMatrixWhoseSumIsDivisibleByK();

        int[][] grid1 = {{5,2,4},{3,0,5},{0,7,2}};
        System.out.println(solver.numberOfPaths(grid1, 3)); // expected 2

        int[][] grid2 = {{0,0}};
        System.out.println(solver.numberOfPaths(grid2, 5)); // expected 1

        int[][] grid3 = {{7,3,4,9},{2,3,6,2},{2,3,7,0}};
        System.out.println(solver.numberOfPaths(grid3, 1)); // expected 10
    }
}
