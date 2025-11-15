import java.util.*;

public class CountTheNumberOfSubstringsWithDominantOnes {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') zeros.add(i);

        long ans = 0L;
        if (zeros.size() == 0) {
            long len = n;
            return (int)(len * (len + 1) / 2);
        }

        // count pure '1' blocks
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                int j = i;
                while (j < n && s.charAt(j) == '1') j++;
                long len = j - i;
                ans += len * (len + 1) / 2;
                i = j;
            } else i++;
        }

        final int LIMIT = 200;
        int zlen = zeros.size();
        int idxZeroStart = 0;

        for (int l = 0; l < n; l++) {
            while (idxZeroStart < zlen && zeros.get(idxZeroStart) < l) idxZeroStart++;
            int idx = idxZeroStart;
            if (idx >= zlen) continue;

            for (int k = 1; k <= LIMIT; k++) {
                if (idx + k - 1 >= zlen) break;
                int posKthZero = zeros.get(idx + k - 1);
                long r_req = (long)l + 1L * k * k + k - 1L;
                long r0 = Math.max((long)posKthZero, r_req);
                long r_max = (idx + k < zlen) ? (long)zeros.get(idx + k) - 1L : (long)(n - 1);
                if (r0 > r_max) continue;
                ans += (r_max - r0 + 1);
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        CountTheNumberOfSubstringsWithDominantOnes solver = new CountTheNumberOfSubstringsWithDominantOnes();
        System.out.println(solver.numberOfSubstrings("00011"));  // 5
        System.out.println(solver.numberOfSubstrings("101101")); // 16
        // big all-one test
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) sb.append('1');
        System.out.println(solver.numberOfSubstrings(sb.toString())); // should run fast
    }
}
