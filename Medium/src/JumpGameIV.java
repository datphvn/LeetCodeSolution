import java.util.*;

public class JumpGameIV {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int cur = q.poll();

                // Đã tới index cuối
                if (cur == n - 1)
                    return steps;

                // Sang trái
                if (cur - 1 >= 0 && !visited[cur - 1]) {

                    visited[cur - 1] = true;
                    q.offer(cur - 1);
                }

                // Sang phải
                if (cur + 1 < n && !visited[cur + 1]) {

                    visited[cur + 1] = true;
                    q.offer(cur + 1);
                }

                // Jump tới index có cùng value
                for (int nxt : map.get(arr[cur])) {

                    if (!visited[nxt]) {

                        visited[nxt] = true;
                        q.offer(nxt);
                    }
                }

                // Tối ưu để tránh duyệt lại
                map.get(arr[cur]).clear();
            }

            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {

        JumpGameIV solver = new JumpGameIV();

        // Test 1
        int[] arr1 = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(solver.minJumps(arr1)); // 3

        // Test 2
        int[] arr2 = {7};
        System.out.println(solver.minJumps(arr2)); // 0

        // Test 3
        int[] arr3 = {7, 6, 9, 6, 9, 6, 9, 7};
        System.out.println(solver.minJumps(arr3)); // 1

        // Test 4
        int[] arr4 = {6, 1, 9};
        System.out.println(solver.minJumps(arr4)); // 2
    }
}