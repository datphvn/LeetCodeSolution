public class MinimumCommonValue {

    public int getCommon(int[] nums1, int[] nums2) {

        // Pointer cho nums1
        int i = 0;

        // Pointer cho nums2
        int j = 0;

        // Duyệt cho tới khi 1 trong 2 mảng kết thúc
        while (i < nums1.length && j < nums2.length) {

            // Nếu tìm thấy số chung
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }

            // nums1 nhỏ hơn
            // => tăng i
            if (nums1[i] < nums2[j]) {
                i++;
            }

            // nums2 nhỏ hơn
            // => tăng j
            else {
                j++;
            }
        }

        // Không có phần tử chung
        return -1;
    }

    public static void main(String[] args) {

        MinimumCommonValue solver = new MinimumCommonValue();

        // Test 1
        int[] nums1a = {1, 2, 3};
        int[] nums2a = {2, 4};

        System.out.println(
                solver.getCommon(nums1a, nums2a)
        ); // 2

        // Test 2
        int[] nums1b = {1, 2, 3, 6};
        int[] nums2b = {2, 3, 4, 5};

        System.out.println(
                solver.getCommon(nums1b, nums2b)
        ); // 2

        // Test 3
        int[] nums1c = {1, 2, 3};
        int[] nums2c = {4, 5, 6};

        System.out.println(
                solver.getCommon(nums1c, nums2c)
        ); // -1
    }
}