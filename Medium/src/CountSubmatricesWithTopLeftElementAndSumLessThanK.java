import java.util.*;

public class CountSubmatricesWithTopLeftElementAndSumLessThanK {

    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                long up = (i > 0 ? grid[i - 1][j] : 0);
                long left = (j > 0 ? grid[i][j - 1] : 0);
                long diag = (i > 0 && j > 0 ? grid[i - 1][j - 1] : 0);

                grid[i][j] = (int)(grid[i][j] + up + left - diag);

                if (grid[i][j] <= k) {
                    ans++;
                } else {
                    if (j == 0) return ans;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CountSubmatricesWithTopLeftElementAndSumLessThanK solver =
                new CountSubmatricesWithTopLeftElementAndSumLessThanK();

        // Test 1
        int[][] grid1 = {
                {7,6,3},
                {6,6,1}
        };
        System.out.println(solver.countSubmatrices(grid1, 18)); // 4

        // Test 2
        int[][] grid2 = {
                {7,2,9},
                {1,5,0},
                {2,6,6}
        };
        System.out.println(solver.countSubmatrices(grid2, 20)); // 6

        // Test 3
        int[][] grid3 = {
                {1,1},
                {1,1}
        };
        System.out.println(solver.countSubmatrices(grid3, 3)); // 3
    }
}