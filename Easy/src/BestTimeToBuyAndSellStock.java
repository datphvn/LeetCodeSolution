public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();

        // Test 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(solver.maxProfit(prices1)); // ✅ 5

        // Test 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(solver.maxProfit(prices2)); // ✅ 0

        // Test 3
        int[] prices3 = {2, 4, 1};
        System.out.println(solver.maxProfit(prices3)); // ✅ 2

        // Test 4
        int[] prices4 = {1, 2, 3, 4, 5};
        System.out.println(solver.maxProfit(prices4)); // ✅ 4
    }
}
