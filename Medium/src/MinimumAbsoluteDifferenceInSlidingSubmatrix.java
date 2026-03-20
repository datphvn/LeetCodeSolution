import java.util.*;

public class MinimumAbsoluteDifferenceInSlidingSubmatrix {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                List<Integer> v = new ArrayList<>();

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        v.add(grid[x][y]);
                    }
                }

                Collections.sort(v);

                int mn = Integer.MAX_VALUE;
                int prev = v.get(0);

                for (int p = 1; p < v.size(); p++) {
                    if (v.get(p) != prev) {
                        mn = Math.min(mn, v.get(p) - prev);
                    }
                    prev = v.get(p);
                }

                ans[i][j] = (mn == Integer.MAX_VALUE) ? 0 : mn;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInSlidingSubmatrix solver =
                new MinimumAbsoluteDifferenceInSlidingSubmatrix();

        // Test 1
        int[][] grid1 = {
                {1, 8},
                {3, -2}
        };
        System.out.println(Arrays.deepToString(solver.minAbsDiff(grid1, 2)));
        // [[2]]

        // Test 2
        int[][] grid2 = {
                {3, -1}
        };
        System.out.println(Arrays.deepToString(solver.minAbsDiff(grid2, 1)));
        // [[0, 0]]

        // Test 3
        int[][] grid3 = {
                {1, -2, 3},
                {2, 3, 5}
        };
        System.out.println(Arrays.deepToString(solver.minAbsDiff(grid3, 2)));
        // [[1, 2]]
    }
}