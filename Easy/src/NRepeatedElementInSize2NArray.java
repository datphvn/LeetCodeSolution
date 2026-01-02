import java.util.*;

public class NRepeatedElementInSize2NArray {

    // Cách 1: HashSet
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // Cách 2: So sánh cục bộ
    public int repeatedNTimesOptimized(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
            if (i + 2 < n && nums[i] == nums[i + 2]) return nums[i];
            if (i + 3 < n && nums[i] == nums[i + 3]) return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        NRepeatedElementInSize2NArray solver = new NRepeatedElementInSize2NArray();

        // Test 1
        int[] nums1 = {1, 2, 3, 3};
        System.out.println(solver.repeatedNTimes(nums1));           // 3
        System.out.println(solver.repeatedNTimesOptimized(nums1));  // 3

        // Test 2
        int[] nums2 = {2, 1, 2, 5, 3, 2};
        System.out.println(solver.repeatedNTimes(nums2));           // 2
        System.out.println(solver.repeatedNTimesOptimized(nums2));  // 2

        // Test 3
        int[] nums3 = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(solver.repeatedNTimes(nums3));           // 5
        System.out.println(solver.repeatedNTimesOptimized(nums3));  // 5
    }
}
