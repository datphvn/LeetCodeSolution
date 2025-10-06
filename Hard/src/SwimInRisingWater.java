import java.util.*;

public class SwimInRisingWater {

    // Priority Queue (Dijkstra) ket hop
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        int res = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0], x = cur[1], y = cur[2];
            res = Math.max(res, h);
            if (x == n - 1 && y == n - 1) return res;
            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwimInRisingWater solver = new SwimInRisingWater();

        // Test 1
        int[][] grid1 = {{0, 2}, {1, 3}};
        System.out.println(solver.swimInWater(grid1)); // 3

        // Test 2
        int[][] grid2 = {
                {0,1,2,3,4},
                {24,23,22,21,5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10,9,8,7,6}
        };
        System.out.println(solver.swimInWater(grid2)); // 16
    }
}
