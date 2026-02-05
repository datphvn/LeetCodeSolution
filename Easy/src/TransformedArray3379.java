import java.util.Arrays;

public class TransformedArray3379 {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int newIndex = (i + nums[i]) % n;
                if (newIndex < 0) {
                    newIndex += n;
                }
                result[i] = nums[newIndex];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TransformedArray3379 solver = new TransformedArray3379();

        // Test 1
        int[] nums1 = {3, -2, 1, 1};
        System.out.println(Arrays.toString(
                solver.constructTransformedArray(nums1)
        ));
        // Expected: [1, 1, 1, 3]

        // Test 2
        int[] nums2 = {-1, 4, -1};
        System.out.println(Arrays.toString(
                solver.constructTransformedArray(nums2)
        ));
        // Expected: [-1, -1, 4]

        // Test 3
        int[] nums3 = {0, 1, -1};
        System.out.println(Arrays.toString(
                solver.constructTransformedArray(nums3)
        ));
        // Expected: [0, -1, 1]
    }
}
