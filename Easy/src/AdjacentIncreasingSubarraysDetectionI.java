import java.util.*;

public class AdjacentIncreasingSubarraysDetectionI {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int inc = 1;
        int lastGood = -1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) inc++;
            else inc = 1;

            if (inc >= k) {
                int start = i - k + 1;
                if (start - lastGood == k) return true;
                lastGood = start;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        AdjacentIncreasingSubarraysDetectionI solver = new AdjacentIncreasingSubarraysDetectionI();

        System.out.println(solver.hasIncreasingSubarrays(Arrays.asList(2,5,7,8,9,2,3,4,3,1), 3)); 
        System.out.println(solver.hasIncreasingSubarrays(Arrays.asList(1,2,3,4,4,4,4,5,6,7), 5));
        System.out.println(solver.hasIncreasingSubarrays(Arrays.asList(1,2,3,4,5,6), 2));
        System.out.println(solver.hasIncreasingSubarrays(Arrays.asList(5,4,3,2,1), 2));
    }
}
