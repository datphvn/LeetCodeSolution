import java.util.*;

public class CountTheNumberOfSpecialCharactersI {

    // Bit Manipulation
    public int numberOfSpecialChars(String word) {
        int lower = 0;
        int upper = 0;

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower |= (1 << (ch - 'a'));
            } else {
                upper |= (1 << (ch - 'A'));
            }
        }

        int common = lower & upper;

        return Integer.bitCount(common);
    }

    // HashSet
    public int numberOfSpecialCharsHashSet(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(Character.toLowerCase(ch));
            }
        }

        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (lower.contains(ch) && upper.contains(ch)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountTheNumberOfSpecialCharactersI solver =
                new CountTheNumberOfSpecialCharactersI();

        // Test 1
        String word1 = "aaAbcBC";
        System.out.println(solver.numberOfSpecialChars(word1)); // 3
        System.out.println(solver.numberOfSpecialCharsHashSet(word1)); // 3

        // Test 2
        String word2 = "abc";
        System.out.println(solver.numberOfSpecialChars(word2)); // 0
        System.out.println(solver.numberOfSpecialCharsHashSet(word2)); // 0

        // Test 3
        String word3 = "abBCab";
        System.out.println(solver.numberOfSpecialChars(word3)); // 1
        System.out.println(solver.numberOfSpecialCharsHashSet(word3)); // 1

        // Test 4
        String word4 = "aA";
        System.out.println(solver.numberOfSpecialChars(word4)); // 1
        System.out.println(solver.numberOfSpecialCharsHashSet(word4)); // 1

        // Test 5
        String word5 = "XYZ";
        System.out.println(solver.numberOfSpecialChars(word5)); // 0
        System.out.println(solver.numberOfSpecialCharsHashSet(word5)); // 0
    }
}