public class MinimumDistanceToTheTargetElement {

    public int getMinDistance(int[] nums, int target, int start) {
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result = Math.min(result, Math.abs(i - start));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumDistanceToTheTargetElement solver = new MinimumDistanceToTheTargetElement();

        // Test 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(solver.getMinDistance(nums1, 5, 3)); // 1

        // Test 2
        int[] nums2 = {1};
        System.out.println(solver.getMinDistance(nums2, 1, 0)); // 0

        // Test 3
        int[] nums3 = {1, 1, 1, 1, 1};
        System.out.println(solver.getMinDistance(nums3, 1, 2)); // 0
    }
}