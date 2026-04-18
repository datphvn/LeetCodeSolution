public class MirrorDistanceOfAnInteger {

    public int mirrorDistance(int n) {
        int rev = 0;
        for (int x = n; x > 0; x /= 10) {
            rev = rev * 10 + x % 10;
        }
        return Math.abs(rev - n);
    }

    public static void main(String[] args) {
        MirrorDistanceOfAnInteger solver = new MirrorDistanceOfAnInteger();

        // Test 1: n = 25 -> 27
        System.out.println(solver.mirrorDistance(25)); // 27

        // Test 2: n = 10 -> 9
        System.out.println(solver.mirrorDistance(10)); // 9

        // Test 3: n = 7 -> 0
        System.out.println(solver.mirrorDistance(7)); // 0
    }
}