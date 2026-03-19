import java.util.*;

public class CountSubmatricesWithEqualFrequencyOfXAndY {

    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        int[][] px = new int[m][n];
        int[][] py = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                px[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                py[i][j] = (grid[i][j] == 'Y') ? 1 : 0;

                if (i > 0) {
                    px[i][j] += px[i - 1][j];
                    py[i][j] += py[i - 1][j];
                }
                if (j > 0) {
                    px[i][j] += px[i][j - 1];
                    py[i][j] += py[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    px[i][j] -= px[i - 1][j - 1];
                    py[i][j] -= py[i - 1][j - 1];
                }

                if (px[i][j] == py[i][j] && px[i][j] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CountSubmatricesWithEqualFrequencyOfXAndY solver = new CountSubmatricesWithEqualFrequencyOfXAndY();

        // Test 1
        char[][] grid1 = {
                {'X','Y','.'},
                {'Y','.','.'}
        };
        System.out.println(solver.numberOfSubmatrices(grid1)); // 3

        // Test 2
        char[][] grid2 = {
                {'X','X'},
                {'X','Y'}
        };
        System.out.println(solver.numberOfSubmatrices(grid2)); // 0

        // Test 3
        char[][] grid3 = {
                {'.','.'},
                {'.','.'}
        };
        System.out.println(solver.numberOfSubmatrices(grid3)); // 0
    }
}