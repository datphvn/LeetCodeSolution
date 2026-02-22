public class BinaryGap {
    public int binaryGap(int n) {
        int prevIndex = -1;
        int maxDistance = 0;
        int currentIndex = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (prevIndex != -1) {
                    maxDistance = Math.max(maxDistance, currentIndex - prevIndex);
                }
                prevIndex = currentIndex;
            }
            n >>= 1;
            currentIndex++;
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        BinaryGap solver = new BinaryGap();

        // Test 1: n = 22 -> "10110" -> 2
        System.out.println(solver.binaryGap(22)); // 2

        // Test 2: n = 8 -> "1000" -> 0
        System.out.println(solver.binaryGap(8)); // 0

        // Test 3: n = 5 -> "101" -> 2
        System.out.println(solver.binaryGap(5)); // 2

        // Test 4: n = 6 -> "110" -> 1
        System.out.println(solver.binaryGap(6)); // 1
    }
}