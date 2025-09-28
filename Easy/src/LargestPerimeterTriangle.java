import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums); // sắp xếp tăng dần
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle solver = new LargestPerimeterTriangle();

        int[] nums1 = {2, 1, 2};
        System.out.println(solver.largestPerimeter(nums1)); // 5

        int[] nums2 = {1, 2, 1, 10};
        System.out.println(solver.largestPerimeter(nums2)); // 0

        int[] nums3 = {3, 6, 2, 3};
        System.out.println(solver.largestPerimeter(nums3)); // 8
    }
}
