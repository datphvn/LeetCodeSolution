import java.util.*;

public class MinimumTotalDistanceTraveled {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int n = robot.size();
        int m = factory.length;

        long INF = (long)1e18;
        long[][] dp = new long[n+1][m+1];

        for(int i = 0; i <= n; i++)
            Arrays.fill(dp[i], INF);

        for(int j = 0; j <= m; j++)
            dp[0][j] = 0;

        for(int j = 1; j <= m; j++){
            int pos = factory[j-1][0];
            int limit = factory[j-1][1];

            for(int i = 0; i <= n; i++){
                dp[i][j] = dp[i][j-1];

                long dist = 0;

                for(int k = 1; k <= limit && i-k >= 0; k++){
                    dist += Math.abs(robot.get(i-k) - pos);
                    dp[i][j] = Math.min(dp[i][j], dp[i-k][j-1] + dist);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        MinimumTotalDistanceTraveled solver = new MinimumTotalDistanceTraveled();

        // Test 1
        List<Integer> robot1 = Arrays.asList(0, 4, 6);
        int[][] factory1 = {{2, 2}, {6, 2}};
        System.out.println(solver.minimumTotalDistance(robot1, factory1)); // 4

        // Test 2
        List<Integer> robot2 = Arrays.asList(1, -1);
        int[][] factory2 = {{-2, 1}, {2, 1}};
        System.out.println(solver.minimumTotalDistance(robot2, factory2)); // 2

        // Test 3
        List<Integer> robot3 = Arrays.asList(5, 3, 8, 2);
        int[][] factory3 = {{4, 2}, {7, 2}};
        System.out.println(solver.minimumTotalDistance(robot3, factory3)); // output tùy case
    }
}