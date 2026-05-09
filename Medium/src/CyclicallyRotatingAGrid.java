import java.util.*;

public class CyclicallyRotatingAGrid {

    public int[][] rotateGrid(int[][] grid, int k) {

        int top = 0, left = 0;
        int bottom = grid.length - 1;
        int right = grid[0].length - 1;

        while (top < bottom && left < right) {

            int height = bottom - top;
            int width = right - left;

            int perimeter = 2 * height + 2 * width;

            int rotate = k % perimeter;

            while (rotate-- > 0) {

                int temp = grid[top][left];

                // Top row
                for (int i = left; i < right; i++) {
                    grid[top][i] = grid[top][i + 1];
                }

                // Right column
                for (int i = top; i < bottom; i++) {
                    grid[i][right] = grid[i + 1][right];
                }

                // Bottom row
                for (int i = right; i > left; i--) {
                    grid[bottom][i] = grid[bottom][i - 1];
                }

                // Left column
                for (int i = bottom; i > top; i--) {
                    grid[i][left] = grid[i - 1][left];
                }

                grid[top + 1][left] = temp;
            }

            top++;
            left++;
            bottom--;
            right--;
        }

        return grid;
    }

    public void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CyclicallyRotatingAGrid solver = new CyclicallyRotatingAGrid();

        // Test 1
        int[][] grid1 = {
                {40, 10},
                {30, 20}
        };

        int[][] result1 = solver.rotateGrid(grid1, 1);

        solver.printGrid(result1);

        // Expected:
        // [10, 20]
        // [40, 30]

        // Test 2
        int[][] grid2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] result2 = solver.rotateGrid(grid2, 2);

        solver.printGrid(result2);

        // Expected:
        // [3, 4, 8, 12]
        // [2, 11, 10, 16]
        // [1, 7, 6, 15]
        // [5, 9, 13, 14]
    }
}