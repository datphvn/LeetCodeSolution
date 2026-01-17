public class FindTheLargestAreaOfSquareInsideTwoRectangles {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xLeft = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int yBottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int xRight = Math.min(topRight[i][0], topRight[j][0]);
                int yTop = Math.min(topRight[i][1], topRight[j][1]);

                int width = xRight - xLeft;
                int height = yTop - yBottom;

                if (width > 0 && height > 0) {
                    int side = Math.min(width, height);
                    maxArea = Math.max(maxArea, (long) side * side);
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        FindTheLargestAreaOfSquareInsideTwoRectangles solver =
                new FindTheLargestAreaOfSquareInsideTwoRectangles();

        // Example 1
        int[][] bottomLeft1 = {{1,1},{2,2},{3,1}};
        int[][] topRight1 = {{3,3},{4,4},{6,6}};
        System.out.println(solver.largestSquareArea(bottomLeft1, topRight1)); // 1

        // Example 2
        int[][] bottomLeft2 = {{1,1},{1,3},{1,5}};
        int[][] topRight2 = {{5,5},{5,7},{5,9}};
        System.out.println(solver.largestSquareArea(bottomLeft2, topRight2)); // 4

        // Example 3
        int[][] bottomLeft3 = {{1,1},{2,2},{1,2}};
        int[][] topRight3 = {{3,3},{4,4},{3,4}};
        System.out.println(solver.largestSquareArea(bottomLeft3, topRight3)); // 1

        // Example 4
        int[][] bottomLeft4 = {{1,1},{3,3},{3,1}};
        int[][] topRight4 = {{2,2},{4,4},{4,2}};
        System.out.println(solver.largestSquareArea(bottomLeft4, topRight4)); // 0
    }
}
