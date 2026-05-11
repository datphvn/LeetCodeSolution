import java.util.*;

public class SeparateTheDigitsInAnArray {

    // String + ArrayList
    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            String s = String.valueOf(num);

            for (char ch : s.toCharArray()) {

                list.add(ch - '0');
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    // Math approach
    public int[] separateDigitsMath(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            List<Integer> temp = new ArrayList<>();

            while (num > 0) {
                temp.add(num % 10);
                num /= 10;
            }

            for (int i = temp.size() - 1; i >= 0; i--) {
                list.add(temp.get(i));
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

        SeparateTheDigitsInAnArray solver =
                new SeparateTheDigitsInAnArray();

        // Test 1
        int[] nums1 = {13, 25, 83, 77};

        System.out.println(
                Arrays.toString(solver.separateDigits(nums1))
        );

        System.out.println(
                Arrays.toString(solver.separateDigitsMath(nums1))
        );

        // Test 2
        int[] nums2 = {7, 1, 3, 9};

        System.out.println(
                Arrays.toString(solver.separateDigits(nums2))
        );

        System.out.println(
                Arrays.toString(solver.separateDigitsMath(nums2))
        );

        // Test 3
        int[] nums3 = {10921};

        System.out.println(
                Arrays.toString(solver.separateDigits(nums3))
        );

        System.out.println(
                Arrays.toString(solver.separateDigitsMath(nums3))
        );
    }
}