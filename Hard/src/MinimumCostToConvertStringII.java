import java.util.*;

public class MinimumCostToConvertStringII {

    // ===== Solution (Optimized – No TLE) =====
    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {
        int n = source.length();
        long INF = (long) 1e18;

        // 1. Map each string to an id
        Set<String> set = new HashSet<>();
        for (String s : original) set.add(s);
        for (String s : changed) set.add(s);

        List<String> all = new ArrayList<>(set);
        Map<String, Integer> id = new HashMap<>();
        for (int i = 0; i < all.size(); i++) {
            id.put(all.get(i), i);
        }

        // 2. Floyd–Warshall preparation
        int m = all.size();
        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Direct costs
        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 3. Group original strings by length
        Map<Integer, List<String>> byLen = new HashMap<>();
        for (String s : original) {
            byLen.computeIfAbsent(s.length(), x -> new ArrayList<>()).add(s);
        }

        // 4. DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            // No operation
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            // Only try valid lengths
            for (int len : byLen.keySet()) {
                if (i + len > n) continue;

                for (String s : byLen.get(len)) {
                    if (!source.regionMatches(i, s, 0, len)) continue;

                    String t = target.substring(i, i + len);
                    if (!id.containsKey(t)) continue;

                    long c = dist[id.get(s)][id.get(t)];
                    if (c < INF) {
                        dp[i + len] = Math.min(dp[i + len], dp[i] + c);
                    }
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }

    // ===== Main Test =====
    public static void main(String[] args) {
        MinimumCostToConvertStringII solver = new MinimumCostToConvertStringII();

        // Test 1
        System.out.println(
                solver.minimumCost(
                        "abcd",
                        "acbe",
                        new String[]{"a","b","c","c","e","d"},
                        new String[]{"b","c","b","e","b","e"},
                        new int[]{2,5,5,1,2,20}
                )
        ); // Expected: 28

        // Test 2
        System.out.println(
                solver.minimumCost(
                        "abcdefgh",
                        "acdeeghh",
                        new String[]{"bcd","fgh","thh"},
                        new String[]{"cde","thh","ghh"},
                        new int[]{1,3,5}
                )
        ); // Expected: 9

        // Test 3 (Impossible)
        System.out.println(
                solver.minimumCost(
                        "abcdefgh",
                        "addddddd",
                        new String[]{"bcd","defgh"},
                        new String[]{"ddd","ddddd"},
                        new int[]{100,1578}
                )
        ); // Expected: -1
    }
}
