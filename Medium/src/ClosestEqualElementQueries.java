import java.util.*;

public class ClosestEqualElementQueries {

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {
            List<Integer> v = map.get(nums[q]);

            if (v.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(v, q);
            int res = Integer.MAX_VALUE;

            int left = v.get((pos - 1 + v.size()) % v.size());
            int d1 = Math.abs(q - left);
            res = Math.min(res, Math.min(d1, n - d1));

            int right = v.get((pos + 1) % v.size());
            int d2 = Math.abs(q - right);
            res = Math.min(res, Math.min(d2, n - d2));

            ans.add(res);
        }

        return ans;
    }

    public static void main(String[] args) {
        ClosestEqualElementQueries solver = new ClosestEqualElementQueries();

        // Test 1
        int[] nums1 = {1,3,1,4,1,3,2};
        int[] queries1 = {0,3,5};
        System.out.println(solver.solveQueries(nums1, queries1));
        // Expected: [2, -1, 3]

        // Test 2
        int[] nums2 = {1,2,3,4};
        int[] queries2 = {0,1,2,3};
        System.out.println(solver.solveQueries(nums2, queries2));
        // Expected: [-1, -1, -1, -1]

        // Test 3
        int[] nums3 = {5,5,5,5};
        int[] queries3 = {0,1,2,3};
        System.out.println(solver.solveQueries(nums3, queries3));
        // Expected: [1, 1, 1, 1]
    }
}