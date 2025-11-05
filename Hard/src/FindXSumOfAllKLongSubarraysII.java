import java.util.*;

public class FindXSumOfAllKLongSubarraysII {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        Comparator<int[]> cmp = (a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0];
        };

        TreeSet<int[]> top = new TreeSet<>(cmp);
        TreeSet<int[]> rest = new TreeSet<>(cmp);
        Map<Integer, int[]> ref = new HashMap<>();

        long sumTop = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int newFreq = freq.getOrDefault(val, 0) + 1;
            freq.put(val, newFreq);

            if (ref.containsKey(val)) {
                int[] old = ref.get(val);
                if (top.remove(old)) sumTop -= (long) old[0] * old[1];
                rest.remove(old);
            }

            int[] node = new int[]{val, newFreq};
            ref.put(val, node);
            rest.add(node);

            if (top.size() < x) {
                int[] big = rest.pollFirst();
                if (big != null) {
                    top.add(big);
                    sumTop += (long) big[0] * big[1];
                }
            } else if (!rest.isEmpty() && cmp.compare(rest.first(), top.last()) < 0) {
                int[] small = top.pollLast();
                int[] big = rest.pollFirst();
                top.add(big);
                rest.add(small);
                sumTop += (long) big[0] * big[1] - (long) small[0] * small[1];
            }

            if (i >= k - 1) {
                ans[i - k + 1] = sumTop;

                int removeVal = nums[i - k + 1];
                int freqOld = freq.get(removeVal);
                if (freqOld == 1) freq.remove(removeVal);
                else freq.put(removeVal, freqOld - 1);

                int[] old = ref.get(removeVal);
                if (top.remove(old)) sumTop -= (long) old[0] * old[1];
                rest.remove(old);

                if (freq.containsKey(removeVal)) {
                    int[] newNode = new int[]{removeVal, freq.get(removeVal)};
                    ref.put(removeVal, newNode);
                    rest.add(newNode);
                } else {
                    ref.remove(removeVal);
                }

                while (top.size() < x && !rest.isEmpty()) {
                    int[] big = rest.pollFirst();
                    top.add(big);
                    sumTop += (long) big[0] * big[1];
                }
                while (top.size() > x) {
                    int[] small = top.pollLast();
                    rest.add(small);
                    sumTop -= (long) small[0] * small[1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindXSumOfAllKLongSubarraysII solver = new FindXSumOfAllKLongSubarraysII();

        // Test 1
        int[] nums1 = {1, 1, 2, 2, 3, 4, 2, 3};
        int k1 = 6, x1 = 2;
        System.out.println(Arrays.toString(solver.findXSum(nums1, k1, x1)));
        // Expected: [6, 10, 12]

        // Test 2
        int[] nums2 = {3, 8, 7, 8, 7, 5};
        int k2 = 2, x2 = 2;
        System.out.println(Arrays.toString(solver.findXSum(nums2, k2, x2)));
        // Expected: [11, 15, 15, 15, 12]
    }
}
