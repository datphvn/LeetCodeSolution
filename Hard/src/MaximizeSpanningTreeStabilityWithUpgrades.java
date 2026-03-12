import java.util.*;

public class MaximizeSpanningTreeStabilityWithUpgrades {

    private int[] parent, rank;

    private void initDSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return false;

        if (rank[pa] < rank[pb])
            parent[pa] = pb;
        else if (rank[pb] < rank[pa])
            parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }

        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {

        int maxStrength = 0;

        for (int[] e : edges)
            maxStrength = Math.max(maxStrength, e[2]);

        int low = 0;
        int high = maxStrength * 2;
        int ans = -1;

        while (low <= high) {

            int mid = (low + high) >>> 1;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int threshold) {

        initDSU(n);

        int usedUpgrades = 0;

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 1) {

                if (s < threshold)
                    return false;

                if (!union(u, v))
                    return false;
            }
        }

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 0 && s >= threshold)
                union(u, v);
        }

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 0 && s < threshold && 2 * s >= threshold) {

                if (usedUpgrades < k) {

                    if (union(u, v))
                        usedUpgrades++;
                }
            }
        }

        int root = find(0);

        for (int i = 1; i < n; i++)
            if (find(i) != root)
                return false;

        return true;
    }

    public static void main(String[] args) {

        MaximizeSpanningTreeStabilityWithUpgrades solver =
                new MaximizeSpanningTreeStabilityWithUpgrades();

        int[][] edges1 = {
                {0,1,2,1},
                {1,2,3,0}
        };

        System.out.println(
                solver.maxStability(3, edges1, 1)
        );

        int[][] edges2 = {
                {0,1,4,0},
                {1,2,3,0},
                {0,2,1,0}
        };

        System.out.println(
                solver.maxStability(3, edges2, 2)
        );

        int[][] edges3 = {
                {0,1,1,1},
                {1,2,1,1},
                {2,0,1,1}
        };

        System.out.println(
                solver.maxStability(3, edges3, 0)
        );
    }
}