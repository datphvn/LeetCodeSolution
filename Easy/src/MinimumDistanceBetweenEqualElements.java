import java.util.*;

public class MinimumDistanceBetweenEqualElements {
    public int minimumDistance(int[] nums) {
        int len = nums.length;
        int[] last2 = new int[len];
        int res = 200;

        for (int i = 0; i < len; i++) {
            int val = nums[i] - 1;
            int pos = i + 1, pack = last2[val];
            int old = pack & 255, cur = pack >> 8;

            last2[val] = cur | (pos << 8);

            if (old > 0)
                res = Math.min(res, (pos - old) << 1);
        }

        return res == 200 ? -1 : res;
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenEqualElements solver = new MinimumDistanceBetweenEqualElements();

        // Test 1: [1,2,3,1] -> 6
        int[] nums1 = {1,2,3,1};
        System.out.println(solver.minimumDistance(nums1)); // 6

        // Test 2: [1,1] -> 2
        int[] nums2 = {1,1};
        System.out.println(solver.minimumDistance(nums2)); // 2

        // Test 3: [1,2,3] -> -1
        int[] nums3 = {1,2,3};
        System.out.println(solver.minimumDistance(nums3)); // -1

        // Test 4: [2,1,3,2,4,2] -> 4
        int[] nums4 = {2,1,3,2,4,2};
        System.out.println(solver.minimumDistance(nums4)); // 4
    }
}