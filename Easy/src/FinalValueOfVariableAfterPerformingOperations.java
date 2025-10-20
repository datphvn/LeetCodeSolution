public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String op : operations) {
            if (op.contains("++")) X++;
            else X--;
        }
        return X;
    }

    public static void main(String[] args) {
        FinalValueOfVariableAfterPerformingOperations solver = new FinalValueOfVariableAfterPerformingOperations();

        // Test 1
        String[] ops1 = {"--X","X++","X++"};
        System.out.println(solver.finalValueAfterOperations(ops1)); // 1

        // Test 2
        String[] ops2 = {"++X","++X","X++"};
        System.out.println(solver.finalValueAfterOperations(ops2)); // 3

        // Test 3
        String[] ops3 = {"X++","++X","--X","X--"};
        System.out.println(solver.finalValueAfterOperations(ops3)); // 0

        // Test 4 (empty array)
        String[] ops4 = {};
        System.out.println(solver.finalValueAfterOperations(ops4)); // 0
    }
}
