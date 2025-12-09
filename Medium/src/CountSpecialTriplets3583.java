import java.util.*;

public class CountSpecialTriplets3583 {

    static final long MOD = 1_000_000_007L;

    public int specialTriplets(int[] nums) {
        Map<Integer, Long> leftFreq = new HashMap<>();
        Map<Integer, Long> rightFreq = new HashMap<>();

        for (int x : nums) {
            rightFreq.put(x, rightFreq.getOrDefault(x, 0L) + 1);
        }

        long result = 0;

        for (int j = 0; j < nums.length; j++) {
            int mid = nums[j];
            rightFreq.put(mid, rightFreq.get(mid) - 1);

            long leftCount = leftFreq.getOrDefault(mid * 2, 0L);
            long rightCount = rightFreq.getOrDefault(mid * 2, 0L);

            result = (result + leftCount * rightCount) % MOD;

            leftFreq.put(mid, leftFreq.getOrDefault(mid, 0L) + 1);
        }

        return (int) result;
    }

    public static void main(String[] args) {
        CountSpecialTriplets3583 solver = new CountSpecialTriplets3583();

        int[] nums1 = {6, 3, 6};
        System.out.println(solver.specialTriplets(nums1)); // 1

        int[] nums2 = {0, 1, 0, 0};
        System.out.println(solver.specialTriplets(nums2)); // 1

        int[] nums3 = {8, 4, 2, 8, 4};
        System.out.println(solver.specialTriplets(nums3)); // 2
    }
}
