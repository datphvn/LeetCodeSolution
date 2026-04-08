import java.util.*;

public class XORAfterQueries {

    final int mod = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {

        for (int[] t : queries) {
            int l = t[0];
            int r = t[1];
            int k = t[2];
            int v = t[3];

            int idx = l;

            while (idx <= r) {
                long temp = nums[idx];
                nums[idx] = (int)((temp * v) % mod);
                idx += k;
            }
        }

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

    public static void main(String[] args) {
        XORAfterQueries solver = new XORAfterQueries();

        // Test 1
        int[] nums1 = {1, 2, 3, 4, 5};
        int[][] queries1 = {
                {0, 4, 1, 2}, // nhân toàn bộ với 2
                {1, 3, 2, 3}  // index: 1,3 -> nhân 3
        };
        System.out.println(solver.xorAfterQueries(nums1, queries1));

        // Test 2
        int[] nums2 = {10, 20, 30};
        int[][] queries2 = {
                {0, 2, 2, 5} // index: 0,2
        };
        System.out.println(solver.xorAfterQueries(nums2, queries2));

        // Test 3
        int[] nums3 = {0, 0, 0};
        int[][] queries3 = {
                {0, 2, 1, 10}
        };
        System.out.println(solver.xorAfterQueries(nums3, queries3));
    }
}