public class EqualSumGridPartitionI {

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;

        for (int[] row : grid)
            for (int x : row)
                total += x;

        if ((total & 1) == 1) return false;

        long target = total / 2, sum = 0;

        // Horizontal cut
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++)
                sum += grid[i][j];
            if (sum == target) return true;
        }

        // Vertical cut
        sum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++)
                sum += grid[i][j];
            if (sum == target) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        EqualSumGridPartitionI solver = new EqualSumGridPartitionI();

        // Test 1
        int[][] grid1 = {{1,4},{2,3}};
        System.out.println(solver.canPartitionGrid(grid1)); // true

        // Test 2
        int[][] grid2 = {{1,3},{2,4}};
        System.out.println(solver.canPartitionGrid(grid2)); // false

        // Test 3
        int[][] grid3 = {{2,2},{2,2}};
        System.out.println(solver.canPartitionGrid(grid3)); // true
    }
}