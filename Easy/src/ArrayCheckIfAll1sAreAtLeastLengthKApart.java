import java.util.*;

public class ArrayCheckIfAll1sAreAtLeastLengthKApart {

    public boolean kLengthApart(int[] nums, int k) {
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (last != -1 && i - last - 1 < k) {
                    return false;
                }
                last = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayCheckIfAll1sAreAtLeastLengthKApart solver = new ArrayCheckIfAll1sAreAtLeastLengthKApart();

        // Test 1
        int[] nums1 = {1,0,0,0,1,0,0,1};
        System.out.println(solver.kLengthApart(nums1, 2)); // true

        // Test 2
        int[] nums2 = {1,0,0,1,0,1};
        System.out.println(solver.kLengthApart(nums2, 2)); // false

        // Test 3: No 1s → always true
        int[] nums3 = {0,0,0,0};
        System.out.println(solver.kLengthApart(nums3, 3)); // true

        // Test 4: all ones
        int[] nums4 = {1,1,1};
        System.out.println(solver.kLengthApart(nums4, 0)); // true
        System.out.println(solver.kLengthApart(nums4, 1)); // false
    }
}
