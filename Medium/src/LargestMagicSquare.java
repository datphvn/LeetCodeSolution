public class LargestMagicSquare {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    int target = rowSum[i][j + k] - rowSum[i][j];
                    boolean ok = true;

                    for (int r = i; r < i + k && ok; r++) {
                        if (rowSum[r][j + k] - rowSum[r][j] != target) {
                            ok = false;
                        }
                    }

                    for (int c = j; c < j + k && ok; c++) {
                        if (colSum[i + k][c] - colSum[i][c] != target) {
                            ok = false;
                        }
                    }

                    int diag1 = 0, diag2 = 0;
                    for (int d = 0; d < k; d++) {
                        diag1 += grid[i + d][j + d];
                        diag2 += grid[i + d][j + k - 1 - d];
                    }

                    if (diag1 != target || diag2 != target) {
                        ok = false;
                    }

                    if (ok) return k;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        LargestMagicSquare solver = new LargestMagicSquare();

        // Test 1
        int[][] grid1 = {
                {7, 1, 4, 5, 6},
                {2, 5, 1, 6, 4},
                {1, 5, 4, 3, 2},
                {1, 2, 7, 3, 4}
        };
        System.out.println(solver.largestMagicSquare(grid1)); // 3

        // Test 2
        int[][] grid2 = {
                {5, 1, 3, 1},
                {9, 3, 3, 1},
                {1, 3, 3, 8}
        };
        System.out.println(solver.largestMagicSquare(grid2)); // 2

        // Test 3
        int[][] grid3 = {{1}};
        System.out.println(solver.largestMagicSquare(grid3)); // 1
    }
}
