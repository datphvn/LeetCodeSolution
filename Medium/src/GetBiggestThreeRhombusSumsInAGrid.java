import java.util.*;

public class GetBiggestThreeRhombusSumsInAGrid {

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        TreeSet<Integer> top3 = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                top3.add(grid[i][j]);
                if (top3.size() > 3) {
                    top3.pollFirst();
                }

                for (int k = 1; i - k >= 0 && i + k < m && j - k >= 0 && j + k < n; k++) {

                    int topR = i - k, topC = j;
                    int rightR = i, rightC = j + k;
                    int bottomR = i + k, bottomC = j;
                    int leftR = i, leftC = j - k;

                    long border = 0;

                    border += diag1[rightR + 1][rightC + 1] - diag1[topR][topC];

                    border += diag2[bottomR + 1][bottomC] - diag2[rightR][rightC + 1];

                    border += diag1[bottomR + 1][bottomC + 1] - diag1[leftR][leftC];

                    border += diag2[leftR + 1][leftC] - diag2[topR][topC + 1];

                    border -= grid[topR][topC];
                    border -= grid[rightR][rightC];
                    border -= grid[bottomR][bottomC];
                    border -= grid[leftR][leftC];

                    top3.add((int) border);
                    if (top3.size() > 3) {
                        top3.pollFirst();
                    }
                }
            }
        }

        int[] ans = new int[top3.size()];
        int idx = 0;

        for (int val : top3.descendingSet()) {
            ans[idx++] = val;
        }

        return ans;
    }

    public static void main(String[] args) {

        GetBiggestThreeRhombusSumsInAGrid solver = new GetBiggestThreeRhombusSumsInAGrid();

        int[][] grid1 = {
                {3,4,5,1,3},
                {3,3,4,2,3},
                {20,30,200,40,10},
                {1,5,5,4,1},
                {4,3,2,2,5}
        };

        System.out.println(Arrays.toString(solver.getBiggestThree(grid1)));
        // [228, 216, 211]

        int[][] grid2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println(Arrays.toString(solver.getBiggestThree(grid2)));
        // [20, 9, 8]

        int[][] grid3 = {
                {7,7,7}
        };

        System.out.println(Arrays.toString(solver.getBiggestThree(grid3)));
        // [7]
    }
}