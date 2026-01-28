import java.util.*;

public class MinimumCostPathWithTeleportations {

    static class StateMinimumCostPathWithTeleportations {
        int r, c, t, cost;
        StateMinimumCostPathWithTeleportations(int r, int c, int t, int cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE;

        int[][][] dist = new int[m][n][k + 1];
        for (int[][] layer : dist)
            for (int[] row : layer)
                Arrays.fill(row, INF);

        PriorityQueue<StateMinimumCostPathWithTeleportations> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        dist[0][0][0] = 0;
        pq.add(new StateMinimumCostPathWithTeleportations(0, 0, 0, 0));

        // Sort all cells by value (for teleport unlock)
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));

        int[] ptr = new int[k + 1];

        while (!pq.isEmpty()) {
            StateMinimumCostPathWithTeleportations cur = pq.poll();
            int r = cur.r, c = cur.c, t = cur.t, cost = cur.cost;

            if (cost > dist[r][c][t]) continue;
            if (r == m - 1 && c == n - 1) return cost;

            // Move Right
            if (c + 1 < n) {
                int ncost = cost + grid[r][c + 1];
                if (ncost < dist[r][c + 1][t]) {
                    dist[r][c + 1][t] = ncost;
                    pq.add(new StateMinimumCostPathWithTeleportations(r, c + 1, t, ncost));
                }
            }

            // Move Down
            if (r + 1 < m) {
                int ncost = cost + grid[r + 1][c];
                if (ncost < dist[r + 1][c][t]) {
                    dist[r + 1][c][t] = ncost;
                    pq.add(new StateMinimumCostPathWithTeleportations(r + 1, c, t, ncost));
                }
            }

            // Teleport unlock
            if (t < k) {
                while (ptr[t] < cells.size() && cells.get(ptr[t])[0] <= grid[r][c]) {
                    int nr = cells.get(ptr[t])[1];
                    int nc = cells.get(ptr[t])[2];
                    if (cost < dist[nr][nc][t + 1]) {
                        dist[nr][nc][t + 1] = cost;
                        pq.add(new StateMinimumCostPathWithTeleportations(nr, nc, t + 1, cost));
                    }
                    ptr[t]++;
                }
            }
        }

        return -1;
    }

    // ================= MAIN TEST =================
    public static void main(String[] args) {
        MinimumCostPathWithTeleportations solver =
                new MinimumCostPathWithTeleportations();

        // Test 1
        int[][] grid1 = {
                {1, 3, 3},
                {2, 5, 4},
                {4, 3, 5}
        };
        int k1 = 2;
        System.out.println(solver.minCost(grid1, k1)); // Expected: 7

        // Test 2
        int[][] grid2 = {
                {1, 2},
                {2, 3},
                {3, 4}
        };
        int k2 = 1;
        System.out.println(solver.minCost(grid2, k2)); // Expected: 9

        // Test 3: No teleport
        int[][] grid3 = {
                {5, 1, 2},
                {4, 8, 3},
                {7, 6, 9}
        };
        int k3 = 0;
        System.out.println(solver.minCost(grid3, k3)); // Normal path only

        // Test 4: Single teleport jump
        int[][] grid4 = {
                {10, 100, 100},
                {1, 100, 100},
                {1, 1, 1}
        };
        int k4 = 1;
        System.out.println(solver.minCost(grid4, k4)); // Expect small value
    }
}
