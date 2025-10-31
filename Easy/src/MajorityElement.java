import java.util.*;

public class MajorityElement {
    // Boyer–Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // HashMap Counting
    public int majorityElementMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) return num;
        }

        return -1;
    }

    public static void main(String[] args) {
        MajorityElement solver = new MajorityElement();

        // Test 1
        int[] nums1 = {3, 2, 3};
        System.out.println(solver.majorityElement(nums1));      // 3
        System.out.println(solver.majorityElementMap(nums1));   // 3

        // Test 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(solver.majorityElement(nums2));      // 2
        System.out.println(solver.majorityElementMap(nums2));   // 2

        // Test 3
        int[] nums3 = {1};
        System.out.println(solver.majorityElement(nums3));      // 1
        System.out.println(solver.majorityElementMap(nums3));   // 1
    }
}
