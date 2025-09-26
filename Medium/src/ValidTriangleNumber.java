import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ValidTriangleNumber solver = new ValidTriangleNumber();

        int[] nums1 = {2, 2, 3, 4};
        System.out.println(solver.triangleNumber(nums1)); // 3

        int[] nums2 = {4, 2, 3, 4};
        System.out.println(solver.triangleNumber(nums2)); // 4

        int[] nums3 = {1, 1, 1, 1};
        System.out.println(solver.triangleNumber(nums3)); // 4
    }
}
