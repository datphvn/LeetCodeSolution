public class FindKthBitInNthBinaryString {

    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int len = (1 << n) - 1;
        int mid = (len + 1) / 2;

        if (k == mid) return '1';
        if (k < mid) return findKthBit(n - 1, k);

        char c = findKthBit(n - 1, len - k + 1);
        return c == '0' ? '1' : '0';
    }

    public static void main(String[] args) {
        FindKthBitInNthBinaryString solver = new FindKthBitInNthBinaryString();

        // Test 1: n = 3, k = 1 -> "0"
        System.out.println(solver.findKthBit(3, 1)); // 0

        // Test 2: n = 4, k = 11 -> "1"
        System.out.println(solver.findKthBit(4, 11)); // 1

        // Test 3: n = 1, k = 1 -> "0"
        System.out.println(solver.findKthBit(1, 1)); // 0
    }
}