import java.util.*;

public class MaximizeAreaOfSquareHoleInGrid {

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = longestConsecutive(hBars);
        int maxV = longestConsecutive(vBars);

        int side = Math.min(maxH, maxV);
        return side * side;
    }

    private int longestConsecutive(int[] bars) {
        Arrays.sort(bars);
        int max = 1;
        int curr = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        MaximizeAreaOfSquareHoleInGrid solver =
                new MaximizeAreaOfSquareHoleInGrid();

        // Test 1
        int[] h1 = {2, 3};
        int[] v1 = {2};
        System.out.println(solver.maximizeSquareHoleArea(2, 1, h1, v1)); // 4

        // Test 2
        int[] h2 = {2};
        int[] v2 = {2};
        System.out.println(solver.maximizeSquareHoleArea(1, 1, h2, v2)); // 4

        // Test 3
        int[] h3 = {2, 3};
        int[] v3 = {2, 4};
        System.out.println(solver.maximizeSquareHoleArea(2, 3, h3, v3)); // 4
    }
}
