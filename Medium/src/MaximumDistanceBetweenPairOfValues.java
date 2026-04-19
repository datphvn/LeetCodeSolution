public class MaximumDistanceBetweenPairOfValues {

    // Two Pointers
    public int maxDistance(int[] A, int[] B) {
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                j++;
            } else {
                i++;
            }
        }

        return Math.max(0, j - i - 1);
    }

    // Binary Search
    public int maxDistanceBinary(int[] nums1, int[] nums2) {
        int res = 0;

        for (int i = 0; i < nums1.length; i++) {
            int left = i, right = nums2.length - 1, ans = i - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums2[mid] >= nums1[i]) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            res = Math.max(res, ans - i);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumDistanceBetweenPairOfValues solver = new MaximumDistanceBetweenPairOfValues();

        // Test 1
        int[] A1 = {55,30,5,4,2};
        int[] B1 = {100,20,10,10,5};
        System.out.println(solver.maxDistance(A1, B1));        // 2
        System.out.println(solver.maxDistanceBinary(A1, B1));  // 2

        // Test 2
        int[] A2 = {2,2,2};
        int[] B2 = {10,10,1};
        System.out.println(solver.maxDistance(A2, B2));        // 1
        System.out.println(solver.maxDistanceBinary(A2, B2));  // 1

        // Test 3
        int[] A3 = {30,29,19,5};
        int[] B3 = {25,25,25,25,25};
        System.out.println(solver.maxDistance(A3, B3));        // 2
        System.out.println(solver.maxDistanceBinary(A3, B3));  // 2
    }
}