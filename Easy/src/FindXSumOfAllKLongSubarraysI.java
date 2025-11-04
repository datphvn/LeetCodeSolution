import java.util.*;

public class FindXSumOfAllKLongSubarraysI {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            // Đếm tần suất trong subarray hiện tại
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Sắp xếp theo quy tắc (tần suất giảm, giá trị giảm)
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
            list.sort((a, b) -> {
                if (!b.getValue().equals(a.getValue()))
                    return b.getValue() - a.getValue();
                return b.getKey() - a.getKey();
            });

            // Lấy top x phần tử
            int sum = 0;
            for (int t = 0; t < Math.min(x, list.size()); t++) {
                int val = list.get(t).getKey();
                int cnt = list.get(t).getValue();
                sum += val * cnt;
            }

            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        FindXSumOfAllKLongSubarraysI solver = new FindXSumOfAllKLongSubarraysI();

        // Test 1
        int[] nums1 = {1, 1, 2, 2, 3, 4, 2, 3};
        int k1 = 6, x1 = 2;
        System.out.println(Arrays.toString(solver.findXSum(nums1, k1, x1)));
        // Output: [6, 10, 12]

        // Test 2
        int[] nums2 = {3, 8, 7, 8, 7, 5};
        int k2 = 2, x2 = 2;
        System.out.println(Arrays.toString(solver.findXSum(nums2, k2, x2)));
        // Output: [11, 15, 15, 15, 12]

        // Test 3
        int[] nums3 = {5, 5, 5};
        int k3 = 3, x3 = 1;
        System.out.println(Arrays.toString(solver.findXSum(nums3, k3, x3)));
        // Output: [15]
    }
}
