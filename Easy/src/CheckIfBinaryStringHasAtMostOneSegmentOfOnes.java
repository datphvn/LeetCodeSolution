public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    public boolean checkOnesSegmentLoop(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfBinaryStringHasAtMostOneSegmentOfOnes solver =
                new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();

        // Test 1
        String s1 = "1001";
        System.out.println(solver.checkOnesSegment(s1));      // false
        System.out.println(solver.checkOnesSegmentLoop(s1));  // false

        // Test 2
        String s2 = "110";
        System.out.println(solver.checkOnesSegment(s2));      // true
        System.out.println(solver.checkOnesSegmentLoop(s2));  // true

        // Test 3
        String s3 = "111111";
        System.out.println(solver.checkOnesSegment(s3));      // true
        System.out.println(solver.checkOnesSegmentLoop(s3));  // true
    }
}