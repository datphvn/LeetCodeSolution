public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {

    public int minFlips(String s) {
        int n = s.length();
        int res = n;
        int[] op = {0, 0};

        for (int i = 0; i < n; i++)
            op[(s.charAt(i) ^ i) & 1]++;

        for (int i = 0; i < n; i++) {
            op[(s.charAt(i) ^ i) & 1]--;
            op[(s.charAt(i) ^ (n + i)) & 1]++;
            res = Math.min(res, Math.min(op[0], op[1]));
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumNumberOfFlipsToMakeTheBinaryStringAlternating solver =
                new MinimumNumberOfFlipsToMakeTheBinaryStringAlternating();

        // Test 1
        String s1 = "111000";
        System.out.println(solver.minFlips(s1)); // 2

        // Test 2
        String s2 = "010";
        System.out.println(solver.minFlips(s2)); // 0

        // Test 3
        String s3 = "1110";
        System.out.println(solver.minFlips(s3)); // 1
    }
}