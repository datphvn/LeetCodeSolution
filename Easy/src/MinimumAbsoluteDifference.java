import java.util.*;

public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifference solver = new MinimumAbsoluteDifference();

        // Test 1
        int[] arr1 = {4, 2, 1, 3};
        System.out.println(solver.minimumAbsDifference(arr1));
        // [[1,2],[2,3],[3,4]]

        // Test 2
        int[] arr2 = {1, 3, 6, 10, 15};
        System.out.println(solver.minimumAbsDifference(arr2));
        // [[1,3]]

        // Test 3
        int[] arr3 = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(solver.minimumAbsDifference(arr3));
        // [[-14,-10],[19,23],[23,27]]
    }
}
