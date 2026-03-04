public class SpecialPositionsInABinaryMatrix {

    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SpecialPositionsInABinaryMatrix solver = new SpecialPositionsInABinaryMatrix();

        // Test 1
        int[][] mat1 = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        System.out.println(solver.numSpecial(mat1)); // 1

        // Test 2
        int[][] mat2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solver.numSpecial(mat2)); // 3

        // Test 3
        int[][] mat3 = {
                {0, 0},
                {0, 0}
        };
        System.out.println(solver.numSpecial(mat3)); // 0
    }
}