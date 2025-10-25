public class CalculateMoneyInLeetcodeBank {

    //  Mô phỏng từng ngày
    public int totalMoneySimulate(int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            int week = i / 7;
            int day = i % 7;
            total += week + day + 1;
        }
        return total;
    }

    //  Dùng công thức toán học
    public int totalMoneyFormula(int n) {
        int fullWeeks = n / 7;
        int remainingDays = n % 7;

        int totalWeeks = 28 * fullWeeks + 7 * (fullWeeks * (fullWeeks - 1)) / 2;
        int totalRemaining = remainingDays * (remainingDays + 1) / 2 + remainingDays * fullWeeks;

        return totalWeeks + totalRemaining;
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank solver = new CalculateMoneyInLeetcodeBank();

        // Test 1: n = 4 → 10
        System.out.println(solver.totalMoneySimulate(4));    // 10
        System.out.println(solver.totalMoneyFormula(4));     // 10

        // Test 2: n = 10 → 37
        System.out.println(solver.totalMoneySimulate(10));   // 37
        System.out.println(solver.totalMoneyFormula(10));    // 37

        // Test 3: n = 20 → 96
        System.out.println(solver.totalMoneySimulate(20));   // 96
        System.out.println(solver.totalMoneyFormula(20));    // 96
    }
}
