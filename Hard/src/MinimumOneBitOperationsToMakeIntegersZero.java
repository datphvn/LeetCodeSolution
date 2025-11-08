public class MinimumOneBitOperationsToMakeIntegersZero {

    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int bit = 0;
        while ((1 << (bit + 1)) <= n) bit++;
        int mask = 1 << bit;
        return (1 << (bit + 1)) - 1 - minimumOneBitOperations(n ^ mask);
    }

    public static void main(String[] args) {
        MinimumOneBitOperationsToMakeIntegersZero solver = new MinimumOneBitOperationsToMakeIntegersZero();

        // Test 1
        int n1 = 3; // "11" → "01" → "00"
        System.out.println("Input: " + n1);
        System.out.println("Output: " + solver.minimumOneBitOperations(n1)); // 2

        // Test 2
        int n2 = 6; // "110" → 4 steps
        System.out.println("Input: " + n2);
        System.out.println("Output: " + solver.minimumOneBitOperations(n2)); // 4

        // Test 3
        int n3 = 0;
        System.out.println("Input: " + n3);
        System.out.println("Output: " + solver.minimumOneBitOperations(n3)); // 0

        // Test 4
        int n4 = 9; // "1001"
        System.out.println("Input: " + n4);
        System.out.println("Output: " + solver.minimumOneBitOperations(n4)); // 14
    }
}
