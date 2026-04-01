import java.util.*;

public class RobotCollisions {

    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String d) {

        int n = pos.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> pos[a] - pos[b]);

        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);

        Deque<Integer> st = new ArrayDeque<>();

        for (int idx : order) {

            if (d.charAt(idx) == 'R') {
                st.push(idx);
            } else {
                while (!st.isEmpty()) {

                    int top = st.peek();

                    if (h[top] < h[idx]) {
                        alive[top] = false;
                        st.pop();
                        h[idx]--;
                    }
                    else if (h[top] > h[idx]) {
                        alive[idx] = false;
                        h[top]--;
                        break;
                    }
                    else {
                        alive[top] = false;
                        alive[idx] = false;
                        st.pop();
                        break;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (alive[i]) res.add(h[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        RobotCollisions solver = new RobotCollisions();

        // Test 1
        int[] pos1 = {5,4,3,2,1};
        int[] h1 = {2,17,9,15,10};
        String d1 = "RRRRR";
        System.out.println(solver.survivedRobotsHealths(pos1, h1, d1)); // [2,17,9,15,10]

        // Test 2
        int[] pos2 = {3,5,2,6};
        int[] h2 = {10,10,15,12};
        String d2 = "RLRL";
        System.out.println(solver.survivedRobotsHealths(pos2, h2, d2)); // [14]

        // Test 3
        int[] pos3 = {1,2,5,6};
        int[] h3 = {10,10,11,11};
        String d3 = "RLRL";
        System.out.println(solver.survivedRobotsHealths(pos3, h3, d3)); // []
    }
}