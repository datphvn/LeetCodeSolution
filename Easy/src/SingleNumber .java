public class SingleNumber {
    // Dùng XOR
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber solver = new SingleNumber();

        // Test 1
        int[] nums1 = {2, 2, 1};
        System.out.println(solver.singleNumber(nums1)); // 1

        // Test 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(solver.singleNumber(nums2)); // 4

        // Test 3
        int[] nums3 = {1};
        System.out.println(solver.singleNumber(nums3)); // 1
    }
}
