public class SeparateSquaresI {

    public double separateSquares(int[][] squares) {
        double low = 0, high = 0;

        for (int[] s : squares) {
            high = Math.max(high, s[1] + s[2]);
        }

        for (int iter = 0; iter < 100; iter++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0.0;
            double areaAbove = 0.0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];

                if (mid <= y) {
                    areaAbove += l * l;
                } else if (mid >= y + l) {
                    areaBelow += l * l;
                } else {
                    areaBelow += (mid - y) * l;
                    areaAbove += (y + l - mid) * l;
                }
            }

            if (areaBelow < areaAbove) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SeparateSquaresI solver = new SeparateSquaresI();

        // Test 1
        int[][] squares1 = {{0,0,1},{2,2,1}};
        System.out.printf("%.5f%n", solver.separateSquares(squares1)); // 1.00000

        // Test 2
        int[][] squares2 = {{0,0,2},{1,1,1}};
        System.out.printf("%.5f%n", solver.separateSquares(squares2)); // 1.16667
    }
}
