import java.util.*;

public class SetIntersectionSizeAtLeastTwo {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int count = 0;
        int a = -1, b = -1;

        for (int[] in : intervals) {
            int L = in[0], R = in[1];

            boolean hasA = (a >= L && a <= R);
            boolean hasB = (b >= L && b <= R);

            if (hasA && hasB) {
                continue;
            } else if (hasA) {
                count++;
                b = a;
                a = R;
            } else {
                count += 2;
                b = R - 1;
                a = R;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        SetIntersectionSizeAtLeastTwo solver = new SetIntersectionSizeAtLeastTwo();

        // Test 1
        int[][] intervals1 = {{1,3},{3,7},{8,9}};
        System.out.println(solver.intersectionSizeTwo(intervals1)); // 5

        // Test 2
        int[][] intervals2 = {{1,3},{1,4},{2,5},{3,5}};
        System.out.println(solver.intersectionSizeTwo(intervals2)); // 3

        // Test 3
        int[][] intervals3 = {{1,2},{2,3},{2,4},{4,5}};
        System.out.println(solver.intersectionSizeTwo(intervals3)); // 5
    }
}
