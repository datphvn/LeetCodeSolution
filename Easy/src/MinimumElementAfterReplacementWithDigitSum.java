public class MinimumElementAfterReplacementWithDigitSum {

    // Cách 1: Tính tổng chữ số bình thường
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            int sum = digitSum(n);
            min = Math.min(min, sum);
        }

        return min;
    }

    // Hàm tính tổng chữ số
    private int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    // Cách 2: Công thức toán học
    public int minElementFormula(int[] nums) {
        int res = 36;

        for (int n : nums) {
            int digitSum =
                    n - 9 * ((n / 10) + (n / 100) + (n / 1000) + (n / 10000));

            res = Math.min(res, digitSum);
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumElementAfterReplacementWithDigitSum solver =
                new MinimumElementAfterReplacementWithDigitSum();

        // Test 1
        int[] nums1 = {10, 12, 13, 14};
        System.out.println(solver.minElement(nums1)); // 1
        System.out.println(solver.minElementFormula(nums1)); // 1

        // Test 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solver.minElement(nums2)); // 1
        System.out.println(solver.minElementFormula(nums2)); // 1

        // Test 3
        int[] nums3 = {999, 19, 199};
        System.out.println(solver.minElement(nums3)); // 10
        System.out.println(solver.minElementFormula(nums3)); // 10
    }
}