import java.util.*;

public class MinimumPairRemovalToSortArrayI {

    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        int operations = 0;

        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            list.remove(index);
            list.remove(index);
            list.add(index, minSum);

            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumPairRemovalToSortArrayI solver = new MinimumPairRemovalToSortArrayI();

        // Test 1
        int[] nums1 = {5, 2, 3, 1};
        System.out.println(solver.minimumPairRemoval(nums1)); // 2

        // Test 2
        int[] nums2 = {1, 2, 2};
        System.out.println(solver.minimumPairRemoval(nums2)); // 0

        // Test 3
        int[] nums3 = {4, 3, 2, 1};
        System.out.println(solver.minimumPairRemoval(nums3)); // 3
    }
}
