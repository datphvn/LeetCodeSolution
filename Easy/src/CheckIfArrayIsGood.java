import java.util.*;

public class CheckIfArrayIsGood {

    // HashSet Solution
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        Set<Integer> seen = new HashSet<>();
        boolean dup = false;

        for (int num : nums) {
            if (num > n) return false;

            if (seen.contains(num)) {
                if (num < n || dup) return false;
                dup = true;
                continue;
            }

            seen.add(num);
        }

        return dup && seen.size() == n;
    }

    // Sorting Solution
    public boolean isGoodSort(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length - 1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        return nums[n - 1] == n && nums[n] == n;
    }

    public static void main(String[] args) {
        CheckIfArrayIsGood solver = new CheckIfArrayIsGood();

        // Test 1
        int[] nums1 = {2, 1, 3};
        System.out.println(solver.isGood(nums1)); // false

        // Test 2
        int[] nums2 = {1, 3, 3, 2};
        System.out.println(solver.isGood(nums2)); // true

        // Test 3
        int[] nums3 = {1, 1};
        System.out.println(solver.isGood(nums3)); // true

        // Test 4
        int[] nums4 = {3, 4, 4, 1, 2, 1};
        System.out.println(solver.isGood(nums4)); // false
    }
}