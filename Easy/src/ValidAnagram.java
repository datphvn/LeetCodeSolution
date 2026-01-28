import java.util.Arrays;

public class ValidAnagram {

    // Frequency counting
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    // Sorting approach
    public boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();

        // Test 1
        System.out.println(solver.isAnagram("anagram", "nagaram")); // true
        System.out.println(solver.isAnagramSort("anagram", "nagaram")); // true

        // Test 2
        System.out.println(solver.isAnagram("rat", "car")); // false
        System.out.println(solver.isAnagramSort("rat", "car")); // false

        // Test 3: same string
        System.out.println(solver.isAnagram("abc", "abc")); // true

        // Test 4: different frequency
        System.out.println(solver.isAnagram("aacc", "ccac")); // false
    }
}
