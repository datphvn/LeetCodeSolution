import java.util.*;

public class HappyNumber {
    // Cách 1: Dùng HashSet
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // Cách 2: Floyd’s Cycle Detection
    public boolean isHappyFloyd(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int digit = n % 10;
            total += digit * digit;
            n /= 10;
        }
        return total;
    }

    public static void main(String[] args) {
        HappyNumber solver = new HappyNumber();

        // Test 1: n = 19 → true
        System.out.println("Test 1: " + solver.isHappy(19));       // true
        System.out.println("Test 1 (Floyd): " + solver.isHappyFloyd(19)); // true

        // Test 2: n = 2 → false
        System.out.println("Test 2: " + solver.isHappy(2));        // false
        System.out.println("Test 2 (Floyd): " + solver.isHappyFloyd(2));  // false

        // Test 3: n = 7 → true
        System.out.println("Test 3: " + solver.isHappy(7));        // true
        System.out.println("Test 3 (Floyd): " + solver.isHappyFloyd(7));  // true
    }
}
