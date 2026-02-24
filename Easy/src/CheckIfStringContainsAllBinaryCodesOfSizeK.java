public class CheckIfStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {
        int req = 1 << k;
        boolean[] seen = new boolean[req];
        int mask = req - 1;
        int hash = 0;

        for (int i = 0; i < s.length(); ++i) {
            hash = ((hash << 1) & mask) | (s.charAt(i) & 1);

            if (i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                req--;
                if (req == 0) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CheckIfStringContainsAllBinaryCodesOfSizeK solver =
                new CheckIfStringContainsAllBinaryCodesOfSizeK();

        // Test 1
        String s1 = "00110110";
        int k1 = 2;
        System.out.println(solver.hasAllCodes(s1, k1)); // true

        // Test 2
        String s2 = "0110";
        int k2 = 1;
        System.out.println(solver.hasAllCodes(s2, k2)); // true

        // Test 3
        String s3 = "0110";
        int k3 = 2;
        System.out.println(solver.hasAllCodes(s3, k3)); // false

        // Test 4
        String s4 = "0000000001011100";
        int k4 = 4;
        System.out.println(solver.hasAllCodes(s4, k4)); // false
    }
}