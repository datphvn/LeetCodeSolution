import java.util.*;

public class CountUnguardedCellsInTheGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] g : guards) grid[g[0]][g[1]] = 1; // Guard
        for (int[] w : walls) grid[w[0]][w[1]] = 2; // Wall

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] g : guards) {
            for (int[] d : dirs) {
                int r = g[0] + d[0];
                int c = g[1] + d[1];
                while (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    if (grid[r][c] == 0)
                        grid[r][c] = 3; // Mark guarded
                    r += d[0];
                    c += d[1];
                }
            }
        }

        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    unguarded++;
            }
        }
        return unguarded;
    }

    public static void main(String[] args) {
        CountUnguardedCellsInTheGrid solver = new CountUnguardedCellsInTheGrid();

        // Example 1
        int m1 = 4, n1 = 6;
        int[][] guards1 = {{0,0},{1,1},{2,3}};
        int[][] walls1 = {{0,1},{2,2},{1,4}};
        System.out.println(solver.countUnguarded(m1, n1, guards1, walls1)); // 7

        // Example 2
        int m2 = 3, n2 = 3;
        int[][] guards2 = {{1,1}};
        int[][] walls2 = {{0,1},{1,0},{2,1},{1,2}};
        System.out.println(solver.countUnguarded(m2, n2, guards2, walls2)); // 4
    }
}
