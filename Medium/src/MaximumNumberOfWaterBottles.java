public class MaximumNumberOfWaterBottles {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drank = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            empty -= numExchange;
            numExchange++;
            empty++;     // uống chai mới → thêm 1 rỗng
            drank++;
        }
        return drank;
    }

    public static void main(String[] args) {
        MaximumNumberOfWaterBottles solver = new MaximumNumberOfWaterBottles();

        // Test 1
        System.out.println(solver.maxBottlesDrunk(13, 6)); // 15

        // Test 2
        System.out.println(solver.maxBottlesDrunk(10, 3)); // 13

        // Test 3
        System.out.println(solver.maxBottlesDrunk(1, 1)); // 1

        // Test 4
        System.out.println(solver.maxBottlesDrunk(5, 2)); // 9
    }
}
