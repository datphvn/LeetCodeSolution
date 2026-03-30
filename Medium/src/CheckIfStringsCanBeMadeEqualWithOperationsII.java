public class CheckIfStringsCanBeMadeEqualWithOperationsII {
    public boolean checkStrings(String s1, String s2) {
        int[] freq = new int[52];

        for (int i = 0; i < s1.length(); i++) {
            int off = (i & 1) * 26;
            freq[s1.charAt(i) - 'a' + off]++;
            freq[s2.charAt(i) - 'a' + off]--;
        }

        for (int i = 0; i < 52; i++)
            if (freq[i] != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        CheckIfStringsCanBeMadeEqualWithOperationsII solver =
                new CheckIfStringsCanBeMadeEqualWithOperationsII();

        // Test 1
        String s1 = "abcdba";
        String s2 = "cabdab";
        System.out.println(solver.checkStrings(s1, s2)); // true

        // Test 2
        String s3 = "abe";
        String s4 = "bea";
        System.out.println(solver.checkStrings(s3, s4)); // false

        // Test 3
        String s5 = "a";
        String s6 = "a";
        System.out.println(solver.checkStrings(s5, s6)); // true
    }
}