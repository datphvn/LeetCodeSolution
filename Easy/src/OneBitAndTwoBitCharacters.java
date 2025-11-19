public class OneBitAndTwoBitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        while (i < n - 1) {
            if (bits[i] == 1) i += 2;
            else i += 1;
        }

        return i == n - 1;
    }

    public static void main(String[] args) {
        OneBitAndTwoBitCharacters solver = new OneBitAndTwoBitCharacters();

        // Test 1
        int[] bits1 = {1, 0, 0};
        System.out.println(solver.isOneBitCharacter(bits1)); // true

        // Test 2
        int[] bits2 = {1, 1, 1, 0};
        System.out.println(solver.isOneBitCharacter(bits2)); // false

        // Test 3
        int[] bits3 = {0};
        System.out.println(solver.isOneBitCharacter(bits3)); // true

        // Test 4
        int[] bits4 = {1, 1, 0};
        System.out.println(solver.isOneBitCharacter(bits4)); // true
    }
}
