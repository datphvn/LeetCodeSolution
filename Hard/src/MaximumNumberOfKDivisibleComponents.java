import java.util.*;

public class MaximumNumberOfKDivisibleComponents {

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int root = 0;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int[] order = new int[n];
        int idx = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(root);
        parent[root] = -2;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            order[idx++] = u;
            for (int v : g[u]) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    stack.push(v);
                }
            }
        }

        long[] sums = new long[n];
        for (int i = 0; i < n; i++) sums[i] = values[i];

        int cuts = 0;

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            if (u == root) continue;

            if (sums[u] % k == 0) {
                cuts++;
            } else {
                sums[parent[u]] += sums[u];
            }
        }

        return cuts + 1;
    }

    public static void main(String[] args) {
        MaximumNumberOfKDivisibleComponents solver = new MaximumNumberOfKDivisibleComponents();

        // Test 1
        int n1 = 5;
        int[][] edges1 = {{0,2},{1,2},{1,3},{2,4}};
        int[] values1 = {1,8,1,4,4};
        int k1 = 6;
        System.out.println(solver.maxKDivisibleComponents(n1, edges1, values1, k1)); // 2

        // Test 2
        int n2 = 7;
        int[][] edges2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values2 = {3,0,6,1,5,2,1};
        int k2 = 3;
        System.out.println(solver.maxKDivisibleComponents(n2, edges2, values2, k2)); // 3

        // Test 3: 1 node
        int n3 = 1;
        int[][] edges3 = {};
        int[] values3 = {6};
        int k3 = 3;
        System.out.println(solver.maxKDivisibleComponents(n3, edges3, values3, k3)); // 1
    }
}

class NodeMaximumNumberOfKDivisibleComponents {
    int val;
    List<NodeMaximumNumberOfKDivisibleComponents> children = new ArrayList<>();
    NodeMaximumNumberOfKDivisibleComponents(int v) { val = v; }
}
