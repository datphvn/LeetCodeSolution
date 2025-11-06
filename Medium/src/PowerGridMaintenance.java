import java.util.*;

public class PowerGridMaintenance {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSUPowerGridMaintenance dsu = new DSUPowerGridMaintenance(c);

        // Union tất cả các trạm có kết nối
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        // TreeSet cho từng root lưu trạm đang online
        Map<Integer, TreeSet<Integer>> online = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            online.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] isOnline = new boolean[c + 1];
        Arrays.fill(isOnline, true);

        List<Integer> result = new ArrayList<>();

        // Xử lý từng query
        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = dsu.find(x);

            if (type == 1) { // Kiểm tra bảo trì
                if (isOnline[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> set = online.get(root);
                    if (set == null || set.isEmpty()) result.add(-1);
                    else result.add(set.first());
                }
            } else if (type == 2) { // Trạm x tắt
                if (isOnline[x]) {
                    isOnline[x] = false;
                    TreeSet<Integer> set = online.get(root);
                    if (set != null) set.remove(x);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        PowerGridMaintenance solver = new PowerGridMaintenance();

        // Test 1
        int c1 = 5;
        int[][] connections1 = {{1,2},{2,3},{3,4},{4,5}};
        int[][] queries1 = {{1,3},{2,1},{1,1},{2,2},{1,2}};
        System.out.println("Test 1 Output: " + Arrays.toString(
                solver.processQueries(c1, connections1, queries1)
        ));
        // Expected: [3, 2, 3]

        // Test 2
        int c2 = 3;
        int[][] connections2 = {};
        int[][] queries2 = {{1,1},{2,1},{1,1}};
        System.out.println("Test 2 Output: " + Arrays.toString(
                solver.processQueries(c2, connections2, queries2)
        ));
        // Expected: [1, -1]

        // Test 3 (thêm)
        int c3 = 6;
        int[][] connections3 = {{1,2},{2,3},{4,5}};
        int[][] queries3 = {{1,1},{2,2},{1,2},{1,4},{2,4},{1,5}};
        System.out.println("Test 3 Output: " + Arrays.toString(
                solver.processQueries(c3, connections3, queries3)
        ));
        // Expected: [1, 1, 4, 5]
    }
}

//  Union-Find (Disjoint Set Union)
class DSUPowerGridMaintenance {
    int[] parent, rank;

    public DSUPowerGridMaintenance(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;
        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pa] > rank[pb]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}
