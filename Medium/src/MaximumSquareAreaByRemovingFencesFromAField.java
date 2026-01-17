import java.util.*;

public class MaximumSquareAreaByRemovingFencesFromAField {

    private static final long MOD = 1_000_000_007L;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        v[0] = 1;
        v[v.length - 1] = n;

        System.arraycopy(hFences, 0, h, 1, hFences.length);
        System.arraycopy(vFences, 0, v, 1, vFences.length);

        Arrays.sort(h);
        Arrays.sort(v);

        Set<Integer> horizontalDistances = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                horizontalDistances.add(h[j] - h[i]);
            }
        }

        long maxSide = -1;

        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int dist = v[j] - v[i];
                if (horizontalDistances.contains(dist)) {
                    maxSide = Math.max(maxSide, dist);
                }
            }
        }

        if (maxSide == -1) return -1;
        return (int) ((maxSide * maxSide) % MOD);
    }

    public static void main(String[] args) {
        MaximumSquareAreaByRemovingFencesFromAField solver =
                new MaximumSquareAreaByRemovingFencesFromAField();

        // Test 1
        int m1 = 4, n1 = 3;
        int[] h1 = {2, 3};
        int[] v1 = {2};
        System.out.println(solver.maximizeSquareArea(m1, n1, h1, v1)); // 4

        // Test 2
        int m2 = 6, n2 = 7;
        int[] h2 = {2};
        int[] v2 = {4};
        System.out.println(solver.maximizeSquareArea(m2, n2, h2, v2)); // -1
    }
}
