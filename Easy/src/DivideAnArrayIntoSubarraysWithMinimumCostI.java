public class DivideAnArrayIntoSubarraysWithMinimumCostI {

    public int minimumCost(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = nums[0] + nums[i] + nums[j];
                ans = Math.min(ans, cost);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        DivideAnArrayIntoSubarraysWithMinimumCostI solver =
                new DivideAnArrayIntoSubarraysWithMinimumCostI();

        // Test 1
        int[] nums1 = {1, 2, 3, 12};
        System.out.println(solver.minimumCost(nums1)); // 6

        // Test 2
        int[] nums2 = {5, 4, 3};
        System.out.println(solver.minimumCost(nums2)); // 12

        // Test 3
        int[] nums3 = {10, 3, 1, 1};
        System.out.println(solver.minimumCost(nums3)); // 12
    }
}
