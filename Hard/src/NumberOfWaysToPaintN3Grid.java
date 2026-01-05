public class NumberOfWaysToPaintN3Grid {

    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;

        long same = 6; // ABA
        long diff = 6; // ABC

        for (int i = 2; i <= n; i++) {
            long newSame = (same * 3 + diff * 2) % MOD;
            long newDiff = (same * 2 + diff * 2) % MOD;
            same = newSame;
            diff = newDiff;
        }

        return (int)((same + diff) % MOD);
    }

    public static void main(String[] args) {
        NumberOfWaysToPaintN3Grid solver = new NumberOfWaysToPaintN3Grid();

        // Test 1
        System.out.println(solver.numOfWays(1)); // 12

        // Test 2
        System.out.println(solver.numOfWays(2)); // 54

        // Test 3
        System.out.println(solver.numOfWays(5000)); // 30228214
    }
}
