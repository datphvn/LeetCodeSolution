import java.util.*;

public class LongestBalancedSubarrayI {

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evenSet.add(nums[j]);
                } else {
                    oddSet.add(nums[j]);
                }

                if (evenSet.size() == oddSet.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestBalancedSubarrayI solver = new LongestBalancedSubarrayI();

        int[] nums1 = {2, 5, 4, 3};
        System.out.println(solver.longestBalanced(nums1)); // 4

        int[] nums2 = {3, 2, 2, 5, 4};
        System.out.println(solver.longestBalanced(nums2)); // 5

        int[] nums3 = {1, 2, 3, 2};
        System.out.println(solver.longestBalanced(nums3)); // 3

        int[] nums4 = {2};
        System.out.println(solver.longestBalanced(nums4)); // 0
    }
}
