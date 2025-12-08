public class CountOddNumbersInAnIntervalRange {

    // Hàm chính để đếm số lẻ
    public int countOdds(int low, int high) {
        int count = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1) count++;
        return count;
    }

    public static void main(String[] args) {
        CountOddNumbersInAnIntervalRange solver = new CountOddNumbersInAnIntervalRange();

        // Test 1
        int low1 = 3, high1 = 7;  // [3,5,7] -> 3
        System.out.println(solver.countOdds(low1, high1)); // 3

        // Test 2
        int low2 = 8, high2 = 10; // [9] -> 1
        System.out.println(solver.countOdds(low2, high2)); // 1

        // Test 3
        int low3 = 0, high3 = 0; // [] -> 0
        System.out.println(solver.countOdds(low3, high3)); // 0

        // Test 4
        int low4 = 1, high4 = 1; // [1] -> 1
        System.out.println(solver.countOdds(low4, high4)); // 1

        // Test 5
        int low5 = 2, high5 = 2; // [2] -> 0
        System.out.println(solver.countOdds(low5, high5)); // 0
    }
}
