import java.util.*;

public class MinimizeHammingDistanceAfterSwapOperations {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void unite(int a, int b) {
        parent[find(a)] = find(b);
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] swap : allowedSwaps) {
            unite(swap[0], swap[1]);
        }

        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new HashMap<>())
                    .merge(source[i], 1, Integer::sum);
        }

        int hammingDist = 0;

        for (int i = 0; i < n; i++) {
            int root = find(i);
            Map<Integer, Integer> freq = groups.get(root);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.merge(target[i], -1, Integer::sum);
            } else {
                hammingDist++;
            }
        }

        return hammingDist;
    }

    public static void main(String[] args) {
        MinimizeHammingDistanceAfterSwapOperations solver = new MinimizeHammingDistanceAfterSwapOperations();

        // Test 1
        int[] source1 = {1,2,3,4};
        int[] target1 = {2,1,4,5};
        int[][] swaps1 = {{0,1},{2,3}};
        System.out.println(solver.minimumHammingDistance(source1, target1, swaps1)); // 1

        // Test 2
        int[] source2 = {1,2,3,4};
        int[] target2 = {1,3,2,4};
        int[][] swaps2 = {};
        System.out.println(solver.minimumHammingDistance(source2, target2, swaps2)); // 2

        // Test 3
        int[] source3 = {5,1,2,4,3};
        int[] target3 = {1,5,4,2,3};
        int[][] swaps3 = {{0,4},{4,2},{1,3},{1,4}};
        System.out.println(solver.minimumHammingDistance(source3, target3, swaps3)); // 0
    }
}