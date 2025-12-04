import java.util.*;

public class CountCollisionsOnARoad {

    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;

        // Bỏ 'L' ở đầu
        while (left < n && directions.charAt(left) == 'L') left++;
        // Bỏ 'R' ở cuối
        while (right >= 0 && directions.charAt(right) == 'R') right--;

        int collisions = 0;
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S')
                collisions++;
        }
        return collisions;
    }

    // ---------------- TEST ----------------
    public static void main(String[] args) {
        CountCollisionsOnARoad solver = new CountCollisionsOnARoad();

        // Test 1: "RLRSLL" -> 5
        System.out.println(solver.countCollisions("RLRSLL")); // 5

        // Test 2: "LLRR" -> 0
        System.out.println(solver.countCollisions("LLRR")); // 0

        // Test 3: "RSRLRS" -> tự test thêm
        System.out.println(solver.countCollisions("RSRLRS")); // 4

        // Test 4: "S" -> 0
        System.out.println(solver.countCollisions("S")); // 0

        // Test 5: "R" -> 0
        System.out.println(solver.countCollisions("R")); // 0
    }
}
