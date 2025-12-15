public class NumberOfSmoothDescentPeriodsOfAStock {

    public long getDescentPeriods(int[] prices) {
        long result = 0;
        long len = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i - 1] - prices[i] == 1) {
                len++;
            } else {
                len = 1;
            }
            result += len;
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfSmoothDescentPeriodsOfAStock solver =
                new NumberOfSmoothDescentPeriodsOfAStock();

        // Test 1
        int[] prices1 = {3, 2, 1, 4};
        System.out.println(solver.getDescentPeriods(prices1)); // 7

        // Test 2
        int[] prices2 = {8, 6, 7, 7};
        System.out.println(solver.getDescentPeriods(prices2)); // 4

        // Test 3
        int[] prices3 = {1};
        System.out.println(solver.getDescentPeriods(prices3)); // 1
    }
}
