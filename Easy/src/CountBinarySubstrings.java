public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int prev = 0;
        int curr = 1;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                result += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        result += Math.min(prev, curr);
        return result;
    }

    public static void main(String[] args) {
        CountBinarySubstrings solver = new CountBinarySubstrings();

        // Test 1
        String s1 = "00110011";
        System.out.println(solver.countBinarySubstrings(s1)); // 6

        // Test 2
        String s2 = "10101";
        System.out.println(solver.countBinarySubstrings(s2)); // 4

        // Test 3
        String s3 = "000111";
        System.out.println(solver.countBinarySubstrings(s3)); // 3
    }
}
