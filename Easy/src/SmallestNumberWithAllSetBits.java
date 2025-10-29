public class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        int x = 1;
        while (x < n) {
            x = (x << 1) | 1; // tạo số toàn bit 1
        }
        return x;
    }

    public static void main(String[] args) {
        SmallestNumberWithAllSetBits solver = new SmallestNumberWithAllSetBits();

        System.out.println(solver.smallestNumber(5));   // 7 -> 111
        System.out.println(solver.smallestNumber(10));  // 15 -> 1111
        System.out.println(solver.smallestNumber(3));   // 3 -> 11
        System.out.println(solver.smallestNumber(1));   // 1 -> 1
        System.out.println(solver.smallestNumber(8));   // 15 -> 1111
    }
}
