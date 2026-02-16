public class AddDigits {

    // Cách O(1)
    public int addDigits(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }

    // Cách mô phỏng
    public int addDigitsLoop(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        AddDigits solver = new AddDigits();

        // Test 1: 38 -> 2
        System.out.println(solver.addDigits(38));       // 2
        System.out.println(solver.addDigitsLoop(38));   // 2

        // Test 2: 0 -> 0
        System.out.println(solver.addDigits(0));        // 0
        System.out.println(solver.addDigitsLoop(0));    // 0

        // Test 3: 9 -> 9
        System.out.println(solver.addDigits(9));        // 9
        System.out.println(solver.addDigitsLoop(9));    // 9

        // Test 4: 99 -> 9
        System.out.println(solver.addDigits(99));       // 9
        System.out.println(solver.addDigitsLoop(99));   // 9
    }
}
