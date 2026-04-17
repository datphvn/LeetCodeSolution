import java.util.*;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (seen.containsKey(n)) {
                res = Math.min(res, i - seen.get(n));
            }

            int r = reverse(n);
            seen.put(r, i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int reverse(int n) {
        int r = 0;
        while (n > 0) {
            r = r * 10 + (n % 10);
            n /= 10;
        }
        return r;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDistanceBetweenMirrorPairs solver = new MinimumAbsoluteDistanceBetweenMirrorPairs();

        int[] nums1 = {12, 21, 45, 33, 54};
        System.out.println(solver.minMirrorPairDistance(nums1)); // 1

        int[] nums2 = {120, 21};
        System.out.println(solver.minMirrorPairDistance(nums2)); // 1

        int[] nums3 = {21, 120};
        System.out.println(solver.minMirrorPairDistance(nums3)); // -1

        int[] nums4 = {11, 11, 11};
        System.out.println(solver.minMirrorPairDistance(nums4)); // 1
    }
}