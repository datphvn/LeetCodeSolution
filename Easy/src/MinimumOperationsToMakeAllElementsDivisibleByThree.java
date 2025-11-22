public class MinimumOperationsToMakeAllElementsDivisibleByThree {

    public int minimumOperations(int[] nums) {
        int ops = 0;
        for (int x : nums) {
            if (x % 3 != 0) ops++;
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeAllElementsDivisibleByThree solver =
                new MinimumOperationsToMakeAllElementsDivisibleByThree();

        // Test 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solver.minimumOperations(nums1)); // 3

        // Test 2
        int[] nums2 = {3, 6, 9};
        System.out.println(solver.minimumOperations(nums2)); // 0

        // Test 3
        int[] nums3 = {2, 5, 8};
        System.out.println(solver.minimumOperations(nums3)); // 3
    }
}
