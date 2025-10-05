import java.util.*;

public class PacificAtlanticWaterFlow {
    private int m, n;
    private int[][] heights;
    private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, -1);
            dfs(i, n - 1, atlantic, -1);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, -1);
            dfs(m - 1, j, atlantic, -1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || c < 0 || r >= m || c >= n ||
                visited[r][c] || heights[r][c] < prevHeight)
            return;

        visited[r][c] = true;
        for (int[] d : dirs)
            dfs(r + d[0], c + d[1], visited, heights[r][c]);
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solver = new PacificAtlanticWaterFlow();

        int[][] heights1 = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        System.out.println(solver.pacificAtlantic(heights1));


        int[][] heights2 = {{1}};
        System.out.println(solver.pacificAtlantic(heights2));
        // Expected: [[0,0]]
    }
}
