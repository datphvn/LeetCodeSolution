class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            drank += newBottles;
            empty = (empty % numExchange) + newBottles;
        }

        return drank;
    }

    public static void main(String[] args) {
        WaterBottles solver = new WaterBottles();

        // Test 1
        System.out.println(solver.numWaterBottles(9, 3)); // 13

        // Test 2
        System.out.println(solver.numWaterBottles(15, 4)); // 19

        // Test 3 (edge case)
        System.out.println(solver.numWaterBottles(1, 2)); // 1
    }
}
