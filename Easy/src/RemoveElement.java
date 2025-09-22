public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        RemoveElementSolution sol = new RemoveElementSolution();
        int k = sol.removeElement(nums, val);

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

class RemoveElementSolution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
