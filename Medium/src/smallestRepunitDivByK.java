class SmallestIntegerDivisibleByK {

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int remainder = 0;
        for (int len = 1; len <= k; len++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return len;
        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestIntegerDivisibleByK solver = new SmallestIntegerDivisibleByK();

        // Test 1: k = 1 -> 1
        System.out.println(solver.smallestRepunitDivByK(1)); // 1

        // Test 2: k = 2 -> -1
        System.out.println(solver.smallestRepunitDivByK(2)); // -1

        // Test 3: k = 3 -> 3 (111 % 3 == 0)
        System.out.println(solver.smallestRepunitDivByK(3)); // 3

        // Test 4: k = 7 -> 6 (111111 % 7 == 0)
        System.out.println(solver.smallestRepunitDivByK(7)); // 6
    }
}
