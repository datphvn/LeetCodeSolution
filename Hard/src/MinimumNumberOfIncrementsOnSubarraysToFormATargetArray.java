public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    public int minNumberOperations(int[] target) {
        int operations = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1];
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        MinimumNumberOfIncrementsOnSubarraysToFormATargetArray solver =
                new MinimumNumberOfIncrementsOnSubarraysToFormATargetArray();

        // Test 1
        int[] t1 = {1, 2, 3, 2, 1};
        System.out.println(solver.minNumberOperations(t1)); // 3

        // Test 2
        int[] t2 = {3, 1, 1, 2};
        System.out.println(solver.minNumberOperations(t2)); // 4

        // Test 3
        int[] t3 = {3, 1, 5, 4, 2};
        System.out.println(solver.minNumberOperations(t3)); // 7

        // Test 4
        int[] t4 = {1, 1, 1, 1};
        System.out.println(solver.minNumberOperations(t4)); // 1

        // Test 5
        int[] t5 = {5};
        System.out.println(solver.minNumberOperations(t5)); // 5
    }
}
