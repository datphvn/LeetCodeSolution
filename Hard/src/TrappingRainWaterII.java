import java.util.*;

public class TrappingRainWaterII {
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // Add border cells
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = visited[m - 1][j] = true;
        }

        int water = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];

            for (int[] d : DIRS) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (heightMap[nx][ny] < h) {
                    water += h - heightMap[nx][ny];
                }
                pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWaterII solver = new TrappingRainWaterII();

        int[][] heightMap1 = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        System.out.println("Example 1 → " + solver.trapRainWater(heightMap1)); // 4

        int[][] heightMap2 = {
                {3,3,3,3,3},
                {3,2,2,2,3},
                {3,2,1,2,3},
                {3,2,2,2,3},
                {3,3,3,3,3}
        };
        System.out.println("Example 2 → " + solver.trapRainWater(heightMap2)); // 10
    }
}
