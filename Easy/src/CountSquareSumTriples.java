public class CountSquareSumTriples {

    public int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);
                if (c * c == c2 && c <= n) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountSquareSumTriples solver = new CountSquareSumTriples();

        // Test 1: n = 5 -> (3,4,5), (4,3,5) => 2
        System.out.println(solver.countTriples(5)); // 2

        // Test 2: n = 10 -> 4 bộ
        System.out.println(solver.countTriples(10)); // 4

        // Test 3
        System.out.println(solver.countTriples(1)); // 0

        // Test 4
        System.out.println(solver.countTriples(15)); // 4 (thêm 9-12-15 và 12-9-15)
    }
}
