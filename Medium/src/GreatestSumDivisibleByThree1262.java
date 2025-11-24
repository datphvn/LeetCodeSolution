import java.util.*;

public class GreatestSumDivisibleByThree1262 {

    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) mod1.add(num);
            else if (num % 3 == 2) mod2.add(num);
        }

        if (sum % 3 == 0) return sum;

        Collections.sort(mod1);
        Collections.sort(mod2);

        if (sum % 3 == 1) {
            int remove1 = mod1.size() > 0 ? mod1.get(0) : Integer.MAX_VALUE;
            int remove2 = mod2.size() > 1 ? mod2.get(0) + mod2.get(1) : Integer.MAX_VALUE;
            return sum - Math.min(remove1, remove2);
        } else { // sum % 3 == 2
            int remove1 = mod2.size() > 0 ? mod2.get(0) : Integer.MAX_VALUE;
            int remove2 = mod1.size() > 1 ? mod1.get(0) + mod1.get(1) : Integer.MAX_VALUE;
            return sum - Math.min(remove1, remove2);
        }
    }

    public static void main(String[] args) {
        GreatestSumDivisibleByThree1262 solver = new GreatestSumDivisibleByThree1262();

        int[] nums1 = {3, 6, 5, 1, 8};
        int[] nums2 = {4};
        int[] nums3 = {1, 2, 3, 4, 4};

        System.out.println(solver.maxSumDivThree(nums1)); // 18
        System.out.println(solver.maxSumDivThree(nums2)); // 0
        System.out.println(solver.maxSumDivThree(nums3)); // 12
    }
}
