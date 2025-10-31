import java.util.*;

public class TheTwoSneakyNumbersOfDigitville {
    // Cách 1: HashSet
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (seen.contains(num)) result.add(num);
            else seen.add(num);
        }

        return new int[]{result.get(0), result.get(1)};
    }

    // Cách 2: Mảng đếm
    public int[] getSneakyNumbersCount(int[] nums) {
        int n = nums.length - 2;
        int[] count = new int[n];
        int[] result = new int[2];
        int idx = 0;

        for (int num : nums) {
            count[num]++;
            if (count[num] == 2) result[idx++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        TheTwoSneakyNumbersOfDigitville solver = new TheTwoSneakyNumbersOfDigitville();

        // Test 1
        int[] nums1 = {0,1,1,0};
        System.out.println(Arrays.toString(solver.getSneakyNumbers(nums1)));        // [0,1]
        System.out.println(Arrays.toString(solver.getSneakyNumbersCount(nums1)));   // [0,1]

        // Test 2
        int[] nums2 = {0,3,2,1,3,2};
        System.out.println(Arrays.toString(solver.getSneakyNumbers(nums2)));        // [2,3]
        System.out.println(Arrays.toString(solver.getSneakyNumbersCount(nums2)));   // [2,3]

        // Test 3
        int[] nums3 = {7,1,5,4,3,4,6,0,9,5,8,2};
        System.out.println(Arrays.toString(solver.getSneakyNumbers(nums3)));        // [4,5]
        System.out.println(Arrays.toString(solver.getSneakyNumbersCount(nums3)));   // [4,5]
    }
}
