public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        SearchInsertPositionSolution sol = new SearchInsertPositionSolution();
        int result = sol.searchInsert(nums, target);

        System.out.print("nums = [");
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(nums[i]);
        }
        System.out.println("]");
        System.out.println("target = " + target);
        System.out.println("Output index = " + result);
    }
}

class SearchInsertPositionSolution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
