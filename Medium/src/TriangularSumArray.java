public class TriangularSumArray {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int len = n; len > 1; len--) {
            for (int i = 0; i < len - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        TriangularSumArray solver = new TriangularSumArray();

        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(solver.triangularSum(nums1)); // 8

        int[] nums2 = {5};
        System.out.println(solver.triangularSum(nums2)); // 5

        int[] nums3 = {9, 1, 9, 1, 9};
        System.out.println(solver.triangularSum(nums3)); // ví dụ thêm
    }
}
