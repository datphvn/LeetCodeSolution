import java.util.*;

public class AdjacentIncreasingSubarraysDetectionII {

    //dung prefix
    public int maxIncreasingSubarrays(int[] nums) {
        int n = nums.length;

        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) inc[i] = inc[i - 1] + 1;
            else inc[i] = 1;
        }

        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) suf[i] = suf[i + 1] + 1;
            else suf[i] = 1;
        }

        int left = 1, right = n / 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canFind(inc, suf, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canFind(int[] inc, int[] suf, int k) {
        int n = inc.length;
        for (int i = 0; i + 2 * k <= n; i++) {
            if (inc[i + k - 1] >= k && suf[i + k] >= k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AdjacentIncreasingSubarraysDetectionII solver = new AdjacentIncreasingSubarraysDetectionII();

        int[] nums1 = {2,5,7,8,9,2,3,4,3,1};
        System.out.println(solver.maxIncreasingSubarrays(nums1));

        int[] nums2 = {1,2,3,4,4,4,4,5,6,7};
        System.out.println(solver.maxIncreasingSubarrays(nums2));

        int[] nums3 = {-15,-13,4,7};
        System.out.println(solver.maxIncreasingSubarrays(nums3));

        int[] nums4 = {-15,19};
        System.out.println(solver.maxIncreasingSubarrays(nums4));
    }
}
