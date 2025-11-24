import java.util.*;

public class BinaryPrefixDivisibleByFive1018 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int mod = 0;

        for (int b : nums) {
            mod = (mod * 2 + b) % 5;
            result.add(mod == 0);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryPrefixDivisibleByFive1018 solver = new BinaryPrefixDivisibleByFive1018();

        int[] nums1 = {0, 1, 1};
        int[] nums2 = {1, 1, 1};
        int[] nums3 = {1, 0, 1}; // 1, 2, 5

        System.out.println(solver.prefixesDivBy5(nums1)); // [true, false, false]
        System.out.println(solver.prefixesDivBy5(nums2)); // [false, false, false]
        System.out.println(solver.prefixesDivBy5(nums3)); // [false, false, true]
    }
}
