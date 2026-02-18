public class BinaryNumberWithAlternatingBits {

    // Cách 1: So sánh từng bit
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n >>= 1;

        while (n > 0) {
            int curr = n & 1;
            if (curr == prev) return false;
            prev = curr;
            n >>= 1;
        }

        return true;
    }

    // Cách 2: Bit trick
    public boolean hasAlternatingBitsOptimized(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits solver = new BinaryNumberWithAlternatingBits();

        // Test 1: n = 5 (101) -> true
        System.out.println(solver.hasAlternatingBits(5));              // true
        System.out.println(solver.hasAlternatingBitsOptimized(5));     // true

        // Test 2: n = 7 (111) -> false
        System.out.println(solver.hasAlternatingBits(7));              // false
        System.out.println(solver.hasAlternatingBitsOptimized(7));     // false

        // Test 3: n = 11 (1011) -> false
        System.out.println(solver.hasAlternatingBits(11));             // false
        System.out.println(solver.hasAlternatingBitsOptimized(11));    // false

        // Test 4: n = 1 (1) -> true
        System.out.println(solver.hasAlternatingBits(1));              // true
        System.out.println(solver.hasAlternatingBitsOptimized(1));     // true
    }
}
