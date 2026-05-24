import java.util.*;

public class JumpGameV {

    int n;

    public int dfs(int i, int[] arr, int d, int[] dp) {

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = 1;

        // Move right
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {

            // Blocked
            if (arr[j] >= arr[i]) {
                break;
            }

            ans = Math.max(ans, 1 + dfs(j, arr, d, dp));
        }

        // Move left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {

            // Blocked
            if (arr[j] >= arr[i]) {
                break;
            }

            ans = Math.max(ans, 1 + dfs(j, arr, d, dp));
        }

        return dp[i] = ans;
    }

    public int maxJumps(int[] arr, int d) {

        n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d, dp));
        }

        return ans;
    }

    public static void main(String[] args) {

        JumpGameV solver = new JumpGameV();

        // Test 1
        int[] arr1 = {6,4,14,6,8,13,9,7,10,6,12};
        int d1 = 2;
        System.out.println(solver.maxJumps(arr1, d1)); // 4

        // Test 2
        int[] arr2 = {3,3,3,3,3};
        int d2 = 3;
        System.out.println(solver.maxJumps(arr2, d2)); // 1

        // Test 3
        int[] arr3 = {7,6,5,4,3,2,1};
        int d3 = 1;
        System.out.println(solver.maxJumps(arr3, d3)); // 7

        // Test 4
        int[] arr4 = {7,1,7,1,7,1};
        int d4 = 2;
        System.out.println(solver.maxJumps(arr4, d4)); // 2
    }
}