public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = Math.abs(
                            points[i][0] * (points[j][1] - points[k][1]) +
                                    points[j][0] * (points[k][1] - points[i][1]) +
                                    points[k][0] * (points[i][1] - points[j][1])
                    ) / 2.0;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestTriangleArea solver = new LargestTriangleArea();

        int[][] points1 = {{0,0}, {0,1}, {1,0}, {0,2}, {2,0}};
        System.out.println(solver.largestTriangleArea(points1)); // 2.0

        int[][] points2 = {{1,0}, {0,0}, {0,1}};
        System.out.println(solver.largestTriangleArea(points2)); // 0.5

        int[][] points3 = {{-50,-50}, {50,0}, {0,50}};
        System.out.println(solver.largestTriangleArea(points3)); // 3750.0
    }
}
