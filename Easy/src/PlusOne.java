public class PlusOne {
    public static void main(String[] args) {
        PlusOneSolution sol = new PlusOneSolution();

        // Test 1
        int[] digits1 = {1,2,3};
        printResult(digits1, sol.plusOne(digits1)); // [1,2,4]

        // Test 2
        int[] digits2 = {4,3,2,1};
        printResult(digits2, sol.plusOne(digits2)); // [4,3,2,2]

        // Test 3
        int[] digits3 = {9};
        printResult(digits3, sol.plusOne(digits3)); // [1,0]

        // Test 4
        int[] digits4 = {9,9,9};
        printResult(digits4, sol.plusOne(digits4)); // [1,0,0,0]
    }

    private static void printResult(int[] input, int[] output) {
        System.out.print("Input: [");
        for (int i = 0; i < input.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(input[i]);
        }
        System.out.print("] -> Output: [");
        for (int i = 0; i < output.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(output[i]);
        }
        System.out.println("]");
    }
}

class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
