public class ComplementOfBase10Integer {

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int mask = n;

        for (int i = 0; i <= 4; i++)
            mask |= mask >> (1 << i);

        return ~n & mask;
    }

    public static void main(String[] args) {
        ComplementOfBase10Integer solver = new ComplementOfBase10Integer();

        // Test 1
        int n1 = 5;
        System.out.println(solver.bitwiseComplement(n1)); // 2

        // Test 2
        int n2 = 7;
        System.out.println(solver.bitwiseComplement(n2)); // 0

        // Test 3
        int n3 = 10;
        System.out.println(solver.bitwiseComplement(n3)); // 5

        // Test 4
        int n4 = 0;
        System.out.println(solver.bitwiseComplement(n4)); // 1
    }
}