import java.util.*;

class CountNumberOfTrapezoidsIIMain {

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test 1
        int[][] points1 = {{-3,2},{3,0},{2,3},{3,2},{2,-3}};
        System.out.println(solver.countTrapezoids(points1)); // Expected: 2

        // Test 2
        int[][] points2 = {{0,0},{1,0},{0,1},{2,1}};
        System.out.println(solver.countTrapezoids(points2)); // Expected: 1

        // Test 3: Edge case, all points on same vertical line
        int[][] points3 = {{82,7},{82,-9},{82,-52},{82,78}};
        System.out.println(solver.countTrapezoids(points3)); // Expected: 0

        // Test 4: From tricky editorial example
        int[][] points4 = {
                {92,100},{-4,55},{92,-87},{92,-91},{92,-30},
                {27,45},{66,82},{92,79},{92,-89},{-4,95},{92,-70},{-10,-18}
        };
        System.out.println(solver.countTrapezoids(points4)); // Expected: 21
    }
}

class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Long, Map<Long, Set<Integer>>> slopeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int xi = points[i][0], yi = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int xj = points[j][0], yj = points[j][1];
                int dx = xj - xi, dy = yj - yi;
                int g = gcd(dx, dy);
                dx /= g; dy /= g;
                if (dx < 0 || (dx == 0 && dy < 0)) { dx = -dx; dy = -dy; }

                long slopeKey = (((long) dx) << 32) | (dy & 0xffffffffL);
                long lineId = (long) dy * xi - (long) dx * yi;

                Map<Long, Set<Integer>> lineMap = slopeMap.computeIfAbsent(slopeKey, k -> new HashMap<>());
                Set<Integer> set = lineMap.computeIfAbsent(lineId, k -> new HashSet<>());
                set.add(i); set.add(j);
            }
        }

        long slopeSum = 0L;
        for (Map<Long, Set<Integer>> lineMap : slopeMap.values()) {
            long S = 0L, S2 = 0L;
            for (Set<Integer> s : lineMap.values()) {
                int cnt = s.size();
                if (cnt >= 2) {
                    long m = (long) cnt * (cnt - 1) / 2;
                    S += m;
                    S2 += m * m;
                }
            }
            if (S > 0) slopeSum += (S * S - S2) / 2;
        }

        Map<Long, List<Long>> midMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mx = points[i][0] + points[j][0];
                int my = points[i][1] + points[j][1];

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int g = gcd(dx, dy);
                dx /= g; dy /= g;
                if (dx < 0 || (dx == 0 && dy < 0)) { dx = -dx; dy = -dy; }

                long slopeKey = (((long) dx) << 32) | (dy & 0xffffffffL);
                long midKey = (((long) mx) << 32) | (my & 0xffffffffL);

                midMap.computeIfAbsent(midKey, k -> new ArrayList<>()).add(slopeKey);
            }
        }

        long parallelograms = 0L;
        for (List<Long> slopes : midMap.values()) {
            int m = slopes.size();
            if (m < 2) continue;
            long totalPairs = (long) m * (m - 1) / 2;
            Map<Long, Integer> freq = new HashMap<>();
            for (Long sk : slopes) freq.put(sk, freq.getOrDefault(sk, 0) + 1);
            long sameSlopePairs = 0L;
            for (int cnt : freq.values()) if (cnt >= 2) sameSlopePairs += (long) cnt * (cnt - 1) / 2;
            parallelograms += (totalPairs - sameSlopePairs);
        }

        long ansLong = slopeSum - parallelograms;
        if (ansLong < 0) ansLong = 0;
        return (int) ansLong;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a); b = Math.abs(b);
        if (a == 0) return b == 0 ? 1 : b;
        if (b == 0) return a;
        while (b != 0) { int t = a % b; a = b; b = t; }
        return a;
    }
}
