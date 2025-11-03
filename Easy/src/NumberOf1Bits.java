public class NumberOf1Bits {

    // Cách 1: Duyệt từng bit
    public int hammingWeightBitCheck(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }

    // Cách 2: Mẹo n & (n - 1)
    public int hammingWeightOptimized(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits solver = new NumberOf1Bits();

        int n1 = 11; // 1011
        System.out.println(solver.hammingWeightBitCheck(n1));   // 3
        System.out.println(solver.hammingWeightOptimized(n1));  // 3

        int n2 = 128; // 10000000
        System.out.println(solver.hammingWeightBitCheck(n2));   // 1
        System.out.println(solver.hammingWeightOptimized(n2));  // 1

        int n3 = 2147483645; // 1111111111111111111111111111101
        System.out.println(solver.hammingWeightBitCheck(n3));   // 30
        System.out.println(solver.hammingWeightOptimized(n3));  // 30
    }
}
