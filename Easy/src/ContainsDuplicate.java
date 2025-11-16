import java.util.*;

public class ContainsDuplicate {

    // HashSet
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int x : nums) {
            if (seen.contains(x)) return true;
            seen.add(x);
        }

        return false;
    }

    // Sort
    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solver = new ContainsDuplicate();

        // Test 1
        int[] nums1 = {1,2,3,1};
        System.out.println(solver.containsDuplicate(nums1)); // true
        System.out.println(solver.containsDuplicateSort(nums1)); // true

        // Test 2
        int[] nums2 = {1,2,3,4};
        System.out.println(solver.containsDuplicate(nums2)); // false
        System.out.println(solver.containsDuplicateSort(nums2)); // false

        // Test 3
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(solver.containsDuplicate(nums3)); // true
        System.out.println(solver.containsDuplicateSort(nums3)); // true
    }
}
