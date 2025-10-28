import java.util.*;

public class MakeArrayElementsEqualToZero {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (simulate(nums, i, 1)) res++;   // phải
                if (simulate(nums, i, -1)) res++;  // trái
            }
        }
        return res;
    }

    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone();
        int curr = start;
        int direction = dir;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += direction;
            } else {
                arr[curr]--;
                direction *= -1;
                curr += direction;
            }
        }

        for (int num : arr)
            if (num != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        MakeArrayElementsEqualToZero solver = new MakeArrayElementsEqualToZero();

        // Test 1
        int[] nums1 = {1, 0, 2, 0, 3};
        System.out.println(solver.countValidSelections(nums1)); // 2

        // Test 2
        int[] nums2 = {2, 3, 4, 0, 4, 1, 0};
        System.out.println(solver.countValidSelections(nums2)); // 0

        // Test 3
        int[] nums3 = {0};
        System.out.println(solver.countValidSelections(nums3)); // 2 (trái và phải đều hợp lệ)
    }
}
