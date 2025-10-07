import java.util.*;

public class AvoidFloodInTheCity {
    // su dung HashMap để lưu ngày, TreeSet để tìm ngày mưa gần nhất, xong tự xử lý code
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLake = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                ans[i] = -1;
                if (fullLake.containsKey(lake)) {
                    Integer dryDay = dryDays.ceiling(fullLake.get(lake));
                    if (dryDay == null) return new int[0];
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                fullLake.put(lake, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AvoidFloodInTheCity solver = new AvoidFloodInTheCity();

        int[] rains1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solver.avoidFlood(rains1)));
        // Output: [-1, -1, -1, -1]

        int[] rains2 = {1, 2, 0, 0, 2, 1};
        System.out.println(Arrays.toString(solver.avoidFlood(rains2)));
        // Output: [-1, -1, 2, 1, -1, -1] (hoặc [-1, -1, 1, 2, -1, -1])

        int[] rains3 = {1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(solver.avoidFlood(rains3)));
        // Output: []
    }
}
