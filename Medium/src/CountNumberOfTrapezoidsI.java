import java.util.*;

public class CountNumberOfTrapezoidsI {

    static final long MOD = 1_000_000_007;

    private long combinations2(long x) {
        if (x < 2) return 0;
        return (x * (x - 1) / 2) % MOD;
    }

    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> map = new HashMap<>();

        for (int[] p : points) {
            int y = p[1];
            map.put(y, map.getOrDefault(y, 0L) + 1);
        }

        List<Long> base = new ArrayList<>();
        for (long cnt : map.values()) {
            long c2 = combinations2(cnt);
            if (c2 > 0) base.add(c2);
        }

        if (base.size() < 2) return 0;

        long prefix = 0, ans = 0;

        for (long c2 : base) {
            ans = (ans + c2 * prefix) % MOD;
            prefix = (prefix + c2) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        CountNumberOfTrapezoidsI solver = new CountNumberOfTrapezoidsI();

        int[][] points1 = {
                {1,0},{2,0},{3,0},{2,2},{3,2}
        };
        System.out.println(solver.countTrapezoids(points1)); // 3

        int[][] points2 = {
                {0,0},{1,0},{0,1},{2,1}
        };
        System.out.println(solver.countTrapezoids(points2)); // 1
    }
}
