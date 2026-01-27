import java.util.*;

public class MinimumCostPathWithEdgeReversals {

    static class EdgeMinimumCostPathWithEdgeReversals {
        int to;
        int cost;
        EdgeMinimumCostPathWithEdgeReversals(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<EdgeMinimumCostPathWithEdgeReversals>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new EdgeMinimumCostPathWithEdgeReversals(v, w));
            graph[v].add(new EdgeMinimumCostPathWithEdgeReversals(u, 2 * w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long cost = cur[1];

            if (cost > dist[u]) continue;

            for (EdgeMinimumCostPathWithEdgeReversals e : graph[u]) {
                if (dist[e.to] > cost + e.cost) {
                    dist[e.to] = cost + e.cost;
                    pq.add(new long[]{e.to, dist[e.to]});
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }

    public static void main(String[] args) {
        MinimumCostPathWithEdgeReversals solver =
                new MinimumCostPathWithEdgeReversals();

        int n = 3;
        int[][] edges = {
                {2,1,1},
                {1,0,1},
                {2,0,16}
        };

        System.out.println(solver.minCost(n, edges)); // 4
    }
}
