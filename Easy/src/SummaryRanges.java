import java.util.*;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }

        if (start == nums[nums.length - 1]) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + nums[nums.length - 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        SummaryRanges solver = new SummaryRanges();

        int[] nums1 = {0,1,2,4,5,7};
        System.out.println(solver.summaryRanges(nums1)); // ["0->2","4->5","7"]

        int[] nums2 = {0,2,3,4,6,8,9};
        System.out.println(solver.summaryRanges(nums2)); // ["0","2->4","6","8->9"]

        int[] nums3 = {};
        System.out.println(solver.summaryRanges(nums3)); // []

        int[] nums4 = {5};
        System.out.println(solver.summaryRanges(nums4)); // ["5"]
    }
}
