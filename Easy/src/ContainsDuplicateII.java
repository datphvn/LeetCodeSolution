import java.util.*;

public class ContainsDuplicateII {

    // HashMap version
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastPos = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastPos.containsKey(nums[i])) {
                int prev = lastPos.get(nums[i]);
                if (i - prev <= k) return true;
            }
            lastPos.put(nums[i], i);
        }

        return false;
    }

    // Sliding Window with HashSet
    public boolean containsNearbyDuplicateSet(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) return true;

            window.add(nums[i]);

            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII solver = new ContainsDuplicateII();

        int[] nums1 = {1,2,3,1};
        System.out.println(solver.containsNearbyDuplicate(nums1, 3)); // true

        int[] nums2 = {1,0,1,1};
        System.out.println(solver.containsNearbyDuplicate(nums2, 1)); // true

        int[] nums3 = {1,2,3,1,2,3};
        System.out.println(solver.containsNearbyDuplicate(nums3, 2)); // false
    }
}
