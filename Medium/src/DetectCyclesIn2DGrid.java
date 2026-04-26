public class DetectCyclesIn2DGrid {

    private int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};

    private boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[] visit, int m, int n) {
        visit[r * n + c] = true;

        for (int k = 0; k < 4; k++) {
            int nr = r + dirs[k][0];
            int nc = c + dirs[k][1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    grid[nr][nc] == grid[r][c] &&
                    !(nr == pr && nc == pc)) {

                if (visit[nr * n + nc]) return true;

                if (dfs(nr, nc, r, c, grid, visit, m, n))
                    return true;
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visit = new boolean[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i * n + j]) {
                    if (dfs(i, j, -1, -1, grid, visit, m, n))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCyclesIn2DGrid solver = new DetectCyclesIn2DGrid();

        char[][] grid1 = {
                {'a','a','a','a'},
                {'a','b','b','a'},
                {'a','b','b','a'},
                {'a','a','a','a'}
        };
        System.out.println(solver.containsCycle(grid1)); // true

        char[][] grid2 = {
                {'c','c','c','a'},
                {'c','d','c','c'},
                {'c','c','e','c'},
                {'f','c','c','c'}
        };
        System.out.println(solver.containsCycle(grid2)); // true

        char[][] grid3 = {
                {'a','b','b'},
                {'b','z','b'},
                {'b','b','a'}
        };
        System.out.println(solver.containsCycle(grid3)); // false
    }
}