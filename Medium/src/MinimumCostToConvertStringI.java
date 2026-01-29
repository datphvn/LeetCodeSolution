import java.util.*;

public class MinimumCostToConvertStringI {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final long INF = (long) 1e18;
        int ALPHA = 26;

        long[][] dist = new long[ALPHA][ALPHA];

        for (int i = 0; i < ALPHA; i++) {
            for (int j = 0; j < ALPHA; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < ALPHA; k++) {
            for (int i = 0; i < ALPHA; i++) {
                for (int j = 0; j < ALPHA; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (dist[s][t] == INF) return -1;
            ans += dist[s][t];
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumCostToConvertStringI solver = new MinimumCostToConvertStringI();

        // Example 1
        System.out.println(
                solver.minimumCost(
                        "abcd",
                        "acbe",
                        new char[]{'a','b','c','c','e','d'},
                        new char[]{'b','c','b','e','b','e'},
                        new int[]{2,5,5,1,2,20}
                )
        ); // 28

        // Example 2
        System.out.println(
                solver.minimumCost(
                        "aaaa",
                        "bbbb",
                        new char[]{'a','c'},
                        new char[]{'c','b'},
                        new int[]{1,2}
                )
        ); // 12

        // Example 3
        System.out.println(
                solver.minimumCost(
                        "abcd",
                        "abce",
                        new char[]{'a'},
                        new char[]{'e'},
                        new int[]{10000}
                )
        ); // -1
    }
}
