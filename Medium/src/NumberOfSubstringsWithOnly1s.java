public class NumberOfSubstringsWithOnly1s {
    static final long MOD = 1_000_000_007;

    public int numSub(String s) {
        long count = 0;
        long run = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                run++;
            } else {
                count = (count + run * (run + 1) / 2) % MOD;
                run = 0;
            }
        }

        count = (count + run * (run + 1) / 2) % MOD;

        return (int) count;
    }

    public static void main(String[] args) {
        NumberOfSubstringsWithOnly1s solver = new NumberOfSubstringsWithOnly1s();

        // Test 1
        System.out.println(solver.numSub("0110111")); // Expected: 9

        // Test 2
        System.out.println(solver.numSub("101")); // Expected: 2

        // Test 3
        System.out.println(solver.numSub("111111")); // Expected: 21

        // Test 4
        System.out.println(solver.numSub("0")); // Expected: 0

        // Test 5
        System.out.println(solver.numSub("1")); // Expected: 1
    }
}
