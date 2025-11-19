import java.util.*;

public class KeepMultiplyingFoundValuesByTwo {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }

    public static void main(String[] args) {
        KeepMultiplyingFoundValuesByTwo solver = new KeepMultiplyingFoundValuesByTwo();

        // Test 1
        int[] nums1 = {5, 3, 6, 1, 12};
        System.out.println(solver.findFinalValue(nums1, 3)); // 24

        // Test 2
        int[] nums2 = {2, 7, 9};
        System.out.println(solver.findFinalValue(nums2, 4)); // 4

        // Test 3
        int[] nums3 = {1, 2, 4, 8, 16};
        System.out.println(solver.findFinalValue(nums3, 1)); // 32

        // Test 4 (original not found)
        int[] nums4 = {10, 20, 30};
        System.out.println(solver.findFinalValue(nums4, 7)); // 7
    }
}
