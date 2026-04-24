public class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, blanks = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') left++;
            else if (c == 'R') right++;
            else blanks++;
        }

        return Math.abs(left - right) + blanks;
    }

    public static void main(String[] args) {
        FurthestPointFromOrigin solver = new FurthestPointFromOrigin();

        // Test 1: "L_RL__R" -> 3
        System.out.println(solver.furthestDistanceFromOrigin("L_RL__R")); // 3

        // Test 2: "_R__LL_" -> 5
        System.out.println(solver.furthestDistanceFromOrigin("_R__LL_")); // 5

        // Test 3: "_______" -> 7
        System.out.println(solver.furthestDistanceFromOrigin("_______")); // 7
    }
}