import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        boolean[] used = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                if (map.get(a) != b) return false;
            } else {
                if (used[b]) return false;
                map.put(a, b);
                used[b] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings solver = new IsomorphicStrings();

        // Test 1
        System.out.println(solver.isIsomorphic("egg", "add")); // true

        // Test 2
        System.out.println(solver.isIsomorphic("foo", "bar")); // false

        // Test 3
        System.out.println(solver.isIsomorphic("paper", "title")); // true

        // Test 4 (edge case)
        System.out.println(solver.isIsomorphic("a", "b")); // true
    }
}
