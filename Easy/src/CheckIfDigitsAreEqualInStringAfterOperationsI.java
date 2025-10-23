import java.util.*;

public class CheckIfDigitsAreEqualInStringAfterOperationsI {

    public boolean hasSameDigits(String s) {
        List<Integer> digits = new ArrayList<>();
        for (char c : s.toCharArray()) {
            digits.add(c - '0');
        }

        while (digits.size() > 2) {
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < digits.size() - 1; i++) {
                next.add((digits.get(i) + digits.get(i + 1)) % 10);
            }
            digits = next;
        }

        return digits.get(0).equals(digits.get(1));
    }

    public static void main(String[] args) {
        CheckIfDigitsAreEqualInStringAfterOperationsI solver = new CheckIfDigitsAreEqualInStringAfterOperationsI();

        // Test 1
        String s1 = "3902";
        System.out.println(solver.hasSameDigits(s1)); // true

        // Test 2
        String s2 = "34789";
        System.out.println(solver.hasSameDigits(s2)); // false

        // Test 3
        String s3 = "111";
        System.out.println(solver.hasSameDigits(s3)); // true (111 → 22 → 4 → 4==4)
    }
}
