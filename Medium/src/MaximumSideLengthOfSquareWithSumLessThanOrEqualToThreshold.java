public class MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (existsSquare(prefix, mid, threshold, m, n)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean existsSquare(int[][] prefix, int k, int threshold, int m, int n) {
        for (int i = 0; i + k <= m; i++) {
            for (int j = 0; j + k <= n; j++) {
                int sum = prefix[i + k][j + k]
                        - prefix[i][j + k]
                        - prefix[i + k][j]
                        + prefix[i][j];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold solver =
                new MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold();

        int[][] mat1 = {
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2}
        };
        System.out.println(solver.maxSideLength(mat1, 4)); // 2

        int[][] mat2 = {
                {2,2,2,2,2},
                {2,2,2,2,2},
                {2,2,2,2,2},
                {2,2,2,2,2},
                {2,2,2,2,2}
        };
        System.out.println(solver.maxSideLength(mat2, 1)); // 0
    }
}
