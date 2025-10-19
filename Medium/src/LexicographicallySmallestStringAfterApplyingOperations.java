import java.util.*;

public class LexicographicallySmallestStringAfterApplyingOperations {

    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String smallest = s;

        q.add(s);
        visited.add(s);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(smallest) < 0) smallest = cur;

            // Operation 1: Add 'a' to odd indices
            String added = addOperation(cur, a);
            if (visited.add(added)) q.add(added);

            // Operation 2: Rotate right by b
            String rotated = rotateOperation(cur, b);
            if (visited.add(rotated)) q.add(rotated);
        }

        return smallest;
    }

    private String addOperation(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int val = (arr[i] - '0' + a) % 10;
            arr[i] = (char) (val + '0');
        }
        return new String(arr);
    }

    private String rotateOperation(String s, int b) {
        int n = s.length();
        return s.substring(n - b) + s.substring(0, n - b);
    }

    // ----- Main test -----
    public static void main(String[] args) {
        LexicographicallySmallestStringAfterApplyingOperations solver =
                new LexicographicallySmallestStringAfterApplyingOperations();

        // Test 1
        System.out.println(solver.findLexSmallestString("5525", 9, 2)); // Expected: 2050

        // Test 2
        System.out.println(solver.findLexSmallestString("74", 5, 1));   // Expected: 24

        // Test 3
        System.out.println(solver.findLexSmallestString("0011", 4, 2)); // Expected: 0011
    }
}
