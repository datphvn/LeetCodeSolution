public class MinimumPenaltyForAShop {

    public int bestClosingTime(String customers) {
        int penalty = 0;

        // Đóng cửa tại giờ 0
        for (char c : customers.toCharArray()) {
            if (c == 'Y') penalty++;
        }

        int minPenalty = penalty;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }

    public static void main(String[] args) {
        MinimumPenaltyForAShop solver = new MinimumPenaltyForAShop();

        // Test 1
        System.out.println(solver.bestClosingTime("YYNY")); // 2

        // Test 2
        System.out.println(solver.bestClosingTime("NNNNN")); // 0

        // Test 3
        System.out.println(solver.bestClosingTime("YYYY")); // 4
    }
}
