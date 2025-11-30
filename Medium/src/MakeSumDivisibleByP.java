import java.util.*;

public class MakeSumDivisibleByP {
    // Hàm chính
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        int need = (int)(total % p);
        if (need == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int target = (int)((prefix - need + p) % p);

            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }

            map.put((int)prefix, i);
        }

        return res == nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP solver = new MakeSumDivisibleByP();

        // Test 1
        int[] nums1 = {3,1,4,2};
        System.out.println(solver.minSubarray(nums1, 6)); // 1

        // Test 2
        int[] nums2 = {6,3,5,2};
        System.out.println(solver.minSubarray(nums2, 9)); // 2

        // Test 3
        int[] nums3 = {1,2,3};
        System.out.println(solver.minSubarray(nums3, 3)); // 0

        // Test 4 (không thể)
        int[] nums4 = {1,2,3};
        System.out.println(solver.minSubarray(nums4, 7)); // -1
    }
}
