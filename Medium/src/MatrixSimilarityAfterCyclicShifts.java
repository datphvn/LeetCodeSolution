public class MatrixSimilarityAfterCyclicShifts {

    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k %= n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (mat[i][j] != mat[i][(j + k) % n]) {
                        return false;
                    }
                } else {
                    if (mat[i][j] != mat[i][(j - k + n) % n]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MatrixSimilarityAfterCyclicShifts solver = new MatrixSimilarityAfterCyclicShifts();

        // Test 1
        int[][] mat1 = {
                {1, 2, 1, 2},
                {5, 5, 5, 5},
                {6, 3, 6, 3}
        };
        int k1 = 2;
        System.out.println(solver.areSimilar(mat1, k1)); // true

        // Test 2
        int[][] mat2 = {
                {2, 2},
                {2, 2}
        };
        int k2 = 3;
        System.out.println(solver.areSimilar(mat2, k2)); // true

        // Test 3
        int[][] mat3 = {
                {1, 2}
        };
        int k3 = 1;
        System.out.println(solver.areSimilar(mat3, k3)); // false
    }
}