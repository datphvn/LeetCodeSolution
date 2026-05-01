public class RotateFunction {

    // Optimal O(n)
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int F = 0;

        // Calculate total sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }

        int max = F;

        // Calculate F(1)...F(n-1)
        for (int i = 1; i < n; i++) {
            F = F + sum - n * nums[n - i];
            max = Math.max(max, F);
        }

        return max;
    }

    public static void main(String[] args) {
        RotateFunction solver = new RotateFunction();

        // Test 1
        int[] nums1 = {4, 3, 2, 6};
        System.out.println(solver.maxRotateFunction(nums1)); // 26

        // Test 2
        int[] nums2 = {100};
        System.out.println(solver.maxRotateFunction(nums2)); // 0

        // Test 3
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(solver.maxRotateFunction(nums3)); // 40

        // Test 4
        int[] nums4 = {-1, -2, -3};
        System.out.println(solver.maxRotateFunction(nums4)); // -5
    }
}