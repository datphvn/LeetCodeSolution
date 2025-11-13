public class MaximumNumberOfOperationsToMoveOnesToTheEnd {

    public int maxOperations(String s) {
        int n = s.length();
        long ans = 0;
        int ones = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                ones++;
            } else {
                if (i == n - 1 || s.charAt(i + 1) == '1') {
                    ans += ones;
                }
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        MaximumNumberOfOperationsToMoveOnesToTheEnd solver =
                new MaximumNumberOfOperationsToMoveOnesToTheEnd();

        System.out.println(solver.maxOperations("1001101")); // 4
        System.out.println(solver.maxOperations("110"));     // 2
        System.out.println(solver.maxOperations("010010"));  // 3
        System.out.println(solver.maxOperations("00111"));   // 0
        System.out.println(solver.maxOperations("1111"));    // 0
        System.out.println(solver.maxOperations("0000"));    // 0
        System.out.println(solver.maxOperations("1010"));    // 3
    }
}
