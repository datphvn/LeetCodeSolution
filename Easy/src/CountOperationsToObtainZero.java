public class CountOperationsToObtainZero {
    // C1:
    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) num1 -= num2;
            else num2 -= num1;
            count++;
        }
        return count;
    }

    // C2: phép chia
    public int countOperationsOptimized(int num1, int num2) {
        int count = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                count += num1 / num2;
                num1 %= num2;
            } else {
                count += num2 / num1;
                num2 %= num1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountOperationsToObtainZero solver = new CountOperationsToObtainZero();

        // Test 1: num1 = 2, num2 = 3 → 3
        System.out.println(solver.countOperations(2, 3)); // 3
        System.out.println(solver.countOperationsOptimized(2, 3)); // 3

        // Test 2: num1 = 10, num2 = 10 → 1
        System.out.println(solver.countOperations(10, 10)); // 1
        System.out.println(solver.countOperationsOptimized(10, 10)); // 1

        // Test 3: num1 = 0, num2 = 5 → 0
        System.out.println(solver.countOperations(0, 5)); // 0
        System.out.println(solver.countOperationsOptimized(0, 5)); // 0

        // Test 4: num1 = 12, num2 = 4 → 3
        System.out.println(solver.countOperations(12, 4)); // 3
        System.out.println(solver.countOperationsOptimized(12, 4)); // 3
    }
}
