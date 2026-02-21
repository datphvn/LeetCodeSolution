public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (isPrime(setBits)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumberOfSetBitsInBinaryRepresentation solver =
                new PrimeNumberOfSetBitsInBinaryRepresentation();

        // Test 1: left = 6, right = 10 -> 4
        System.out.println(solver.countPrimeSetBits(6, 10)); // 4

        // Test 2: left = 10, right = 15 -> 5
        System.out.println(solver.countPrimeSetBits(10, 15)); // 5

        // Test 3: left = 1, right = 1 -> 0
        System.out.println(solver.countPrimeSetBits(1, 1)); // 0
    }
}