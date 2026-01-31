import java.util.*;

public class FindSmallestLetterGreaterThanTarget {

    // Linear Scan
    public char nextGreatestLetterLinear(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) return c;
        }
        return letters[0];
    }

    // Binary Search
    public char nextGreatestLetterBinary(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget solver = new FindSmallestLetterGreaterThanTarget();

        // Test 1
        char[] letters1 = {'c','f','j'};
        System.out.println(solver.nextGreatestLetterLinear(letters1, 'a'));  // c
        System.out.println(solver.nextGreatestLetterBinary(letters1, 'a'));  // c

        // Test 2
        System.out.println(solver.nextGreatestLetterLinear(letters1, 'c'));  // f
        System.out.println(solver.nextGreatestLetterBinary(letters1, 'c'));  // f

        // Test 3
        char[] letters2 = {'x','x','y','y'};
        System.out.println(solver.nextGreatestLetterLinear(letters2, 'z'));  // x
        System.out.println(solver.nextGreatestLetterBinary(letters2, 'z'));  // x
    }
}
