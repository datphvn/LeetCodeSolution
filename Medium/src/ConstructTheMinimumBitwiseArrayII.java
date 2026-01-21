import java.util.*;

public class ConstructTheMinimumBitwiseArrayII {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            if ((x & (x - 1)) == 0) {
                ans[i] = -1;
                continue;
            }

            int t = 0;
            int temp = x;
            while ((temp & 1) == 1) {
                t++;
                temp >>= 1;
            }

            ans[i] = x - (1 << (t - 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        ConstructTheMinimumBitwiseArrayII solver =
                new ConstructTheMinimumBitwiseArrayII();

        // Test 1
        List<Integer> nums1 = Arrays.asList(2, 3, 5, 7);
        System.out.println(Arrays.toString(
                solver.minBitwiseArray(nums1))); // [-1, 1, 4, 3]

        // Test 2
        List<Integer> nums2 = Arrays.asList(11, 13, 31);
        System.out.println(Arrays.toString(
                solver.minBitwiseArray(nums2))); // [9, 12, 15]
    }
}
