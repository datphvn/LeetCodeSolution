public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;      // Dịch trái 1 bit
            result |= (n & 1); // Thêm bit cuối của n vào result
            n >>>= 1;          // Dịch phải không dấu
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solver = new ReverseBits();

        int n1 = 43261596;
        int output1 = solver.reverseBits(n1);
        System.out.println(output1); // Output: 964176192

        int n2 = 2147483644;
        int output2 = solver.reverseBits(n2);
        System.out.println(output2); // Output: 1073741822
    }
}
