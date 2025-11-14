import java.util.*;

public class IncrementSubmatricesByOne {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            diff[r1][c1] += 1;
            if (c2 + 1 < n) diff[r1][c2 + 1] -= 1;
            if (r2 + 1 < n) diff[r2 + 1][c1] -= 1;
            if (r2 + 1 < n && c2 + 1 < n) diff[r2 + 1][c2 + 1] += 1;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 1; c < n; c++) {
                diff[r][c] += diff[r][c - 1];
            }
        }

        for (int c = 0; c < n; c++) {
            for (int r = 1; r < n; r++) {
                diff[r][c] += diff[r - 1][c];
            }
        }

        int[][] result = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result[r][c] = diff[r][c];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        IncrementSubmatricesByOne solver = new IncrementSubmatricesByOne();

        // Test 1
        int n1 = 3;
        int[][] q1 = {{1,1,2,2},{0,0,1,1}};
        System.out.println(Arrays.deepToString(solver.rangeAddQueries(n1, q1)));
        // Expected: [[1,1,0],[1,2,1],[0,1,1]]

        // Test 2
        int n2 = 2;
        int[][] q2 = {{0,0,1,1}};
        System.out.println(Arrays.deepToString(solver.rangeAddQueries(n2, q2)));
        // Expected: [[1,1],[1,1]]
    }
}
