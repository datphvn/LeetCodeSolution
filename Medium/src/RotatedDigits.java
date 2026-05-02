public class RotatedDigits {

    public int rotatedDigits(int n) {

        int[] dp = new int[n + 1];
        int count = 0;

        for (int i = 0; i <= n; i++) {

            // One digit
            if (i < 10) {

                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                }
                else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                }
                else {
                    dp[i] = 0;
                }

            } else {

                int a = dp[i / 10];
                int b = dp[i % 10];

                // Both valid and unchanged
                if (a == 1 && b == 1) {
                    dp[i] = 1;
                }

                // At least one digit changes
                else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                }

                // Invalid number
                else {
                    dp[i] = 0;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        RotatedDigits solver = new RotatedDigits();

        // Test 1
        int n1 = 10;
        System.out.println(solver.rotatedDigits(n1)); // 4

        // Test 2
        int n2 = 1;
        System.out.println(solver.rotatedDigits(n2)); // 0

        // Test 3
        int n3 = 2;
        System.out.println(solver.rotatedDigits(n3)); // 1

        // Test 4
        int n4 = 20;
        System.out.println(solver.rotatedDigits(n4)); // 9
    }
}