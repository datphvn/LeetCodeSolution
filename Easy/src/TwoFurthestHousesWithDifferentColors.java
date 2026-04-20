public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] A) {
        int n = A.length;
        int left = 0, right = 0;

        for (int i = 0; i < n; i++)
            if (A[i] != A[n - 1]) {
                left = i;
                break;
            }

        for (int i = n - 1; i >= 0; i--)
            if (A[i] != A[0]) {
                right = i;
                break;
            }

        return Math.max(n - 1 - left, right);
    }

    public static void main(String[] args) {
        TwoFurthestHousesWithDifferentColors solver = new TwoFurthestHousesWithDifferentColors();

        // Test 1
        int[] colors1 = {1,1,1,6,1,1,1};
        System.out.println(solver.maxDistance(colors1)); // 3

        // Test 2
        int[] colors2 = {1,8,3,8,3};
        System.out.println(solver.maxDistance(colors2)); // 4

        // Test 3
        int[] colors3 = {0,1};
        System.out.println(solver.maxDistance(colors3)); // 1
    }
}