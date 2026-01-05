public class FourDivisors {

    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for (int x : nums) {
            int sum = 0;
            int count = 0;

            for (int i = 1; i * i <= x; i++) {
                if (x % i == 0) {
                    int d1 = i;
                    int d2 = x / i;

                    if (d1 == d2) {
                        count++;
                        sum += d1;
                    } else {
                        count += 2;
                        sum += d1 + d2;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                result += sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourDivisors solver = new FourDivisors();

        // Test 1
        int[] nums1 = {21, 4, 7};
        System.out.println(solver.sumFourDivisors(nums1)); // 32

        // Test 2
        int[] nums2 = {21, 21};
        System.out.println(solver.sumFourDivisors(nums2)); // 64

        // Test 3
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(solver.sumFourDivisors(nums3)); // 0
    }
}
