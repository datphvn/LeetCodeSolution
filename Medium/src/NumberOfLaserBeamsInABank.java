public class NumberOfLaserBeamsInABank {

    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int total = 0;

        for (String row : bank) {
            int curr = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') curr++;
            }
            if (curr > 0) {
                total += prev * curr;
                prev = curr;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        NumberOfLaserBeamsInABank solver = new NumberOfLaserBeamsInABank();

        // Test 1
        String[] bank1 = {"011001", "000000", "010100", "001000"};
        System.out.println(solver.numberOfBeams(bank1)); // 8

        // Test 2
        String[] bank2 = {"000", "111", "000"};
        System.out.println(solver.numberOfBeams(bank2)); // 0

        // Test 3
        String[] bank3 = {"1", "0", "1"};
        System.out.println(solver.numberOfBeams(bank3)); // 1

        // Test 4
        String[] bank4 = {"111", "111"};
        System.out.println(solver.numberOfBeams(bank4)); // 9
    }
}
