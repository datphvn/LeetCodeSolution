public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) negativeCount++;
                int absVal = Math.abs(val);
                sum += absVal;
                minAbs = Math.min(minAbs, absVal);
            }
        }

        if (negativeCount % 2 == 0) {
            return sum;
        } else {
            return sum - 2L * minAbs;
        }
    }

    public static void main(String[] args) {
        MaximumMatrixSum solver = new MaximumMatrixSum();

        // Test 1
        int[][] matrix1 = {
                {1, -1},
                {-1, 1}
        };
        System.out.println(solver.maxMatrixSum(matrix1)); // 4

        // Test 2
        int[][] matrix2 = {
                {1, 2, 3},
                {-1, -2, -3},
                {1, 2, 3}
        };
        System.out.println(solver.maxMatrixSum(matrix2)); // 16
    }
}
