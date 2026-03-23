import java.util.*;

public class MaximumNonNegativeProductInAMatrix {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long MOD = 1000000007;

        long[][] mx = new long[m][n];
        long[][] mn = new long[m][n];

        mx[0][0] = mn[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            mx[0][j] = mn[0][j] = mx[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            mx[i][0] = mn[i][0] = mx[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long x = grid[i][j];

                long a = mx[i - 1][j] * x;
                long b = mn[i - 1][j] * x;
                long c = mx[i][j - 1] * x;
                long d = mn[i][j - 1] * x;

                mx[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                mn[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long ans = mx[m - 1][n - 1];
        if (ans < 0) return -1;
        return (int)(ans % MOD);
    }

    public static void main(String[] args) {
        MaximumNonNegativeProductInAMatrix solver = new MaximumNonNegativeProductInAMatrix();

        // Test 1
        int[][] grid1 = {
                {-1,-2,-3},
                {-2,-3,-3},
                {-3,-3,-2}
        };
        System.out.println(solver.maxProductPath(grid1)); // -1

        // Test 2
        int[][] grid2 = {
                {1,-2,1},
                {1,-2,1},
                {3,-4,1}
        };
        System.out.println(solver.maxProductPath(grid2)); // 8

        // Test 3
        int[][] grid3 = {
                {1,3},
                {0,-4}
        };
        System.out.println(solver.maxProductPath(grid3)); // 0
    }
}