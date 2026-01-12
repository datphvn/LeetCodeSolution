public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
            time += Math.max(dx, dy);
        }

        return time;
    }

    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints solver = new MinimumTimeVisitingAllPoints();

        // Test 1
        int[][] points1 = {{1,1},{3,4},{-1,0}};
        System.out.println(solver.minTimeToVisitAllPoints(points1)); // 7

        // Test 2
        int[][] points2 = {{3,2},{-2,2}};
        System.out.println(solver.minTimeToVisitAllPoints(points2)); // 5
    }
}
