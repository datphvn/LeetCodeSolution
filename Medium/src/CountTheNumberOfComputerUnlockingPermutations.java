import java.util.*;

public class CountTheNumberOfComputerUnlockingPermutations {
    private static final long MOD = 1_000_000_007L;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[0] >= complexity[i]) return 0;
        }
        long fact = 1;
        for (int i = 1; i <= n - 1; i++) fact = (fact * i) % MOD;
        return (int) fact;
    }

    public static void main(String[] args) {
        CountTheNumberOfComputerUnlockingPermutations solver =
                new CountTheNumberOfComputerUnlockingPermutations();

        System.out.println(solver.countPermutations(new int[]{1, 2, 3})); // 2 (expected)
        System.out.println(solver.countPermutations(new int[]{3,3,3,4,4,4})); // 0 (expected)
        System.out.println(solver.countPermutations(new int[]{5,1})); // 0
        System.out.println(solver.countPermutations(new int[]{1,1,2,2,3})); // 0 (since complexity[0] not < others)
    }
}
