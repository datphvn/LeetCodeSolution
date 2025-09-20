public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        Solution2 sol = new Solution2();
        int k = sol.removeDuplicates(nums);

        // In kết quả
        System.out.println("k = " + k);
        System.out.print("nums = [");
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) System.out.print(", ");
            if (i < k) {
                System.out.print(nums[i]);
            } else {
                System.out.print("_");
            }
        }
        System.out.println("]");
    }
}

class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
