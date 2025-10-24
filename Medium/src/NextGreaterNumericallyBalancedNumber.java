public class NextGreaterNumericallyBalancedNumber {
    public int nextBeautifulNumber(int n) {
        int x = n + 1;
        while (true) {
            if (isBalanced(x)) return x;
            x++;
        }
    }

    private boolean isBalanced(int num) {
        int[] count = new int[10];
        int tmp = num;

        while (tmp > 0) {
            count[tmp % 10]++;
            tmp /= 10;
        }

        for (int d = 0; d <= 9; d++) {
            if (count[d] != 0 && count[d] != d)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NextGreaterNumericallyBalancedNumber solver = new NextGreaterNumericallyBalancedNumber();

        // Test 1
        int n1 = 1;
        System.out.println(solver.nextBeautifulNumber(n1)); // 22

        // Test 2
        int n2 = 1000;
        System.out.println(solver.nextBeautifulNumber(n2)); // 1333

        // Test 3
        int n3 = 3000;
        System.out.println(solver.nextBeautifulNumber(n3)); // 3133

        // Test 4
        int n4 = 0;
        System.out.println(solver.nextBeautifulNumber(n4)); // 1 -> nhưng 1 chưa balanced, nên kết quả là 22
    }
}
