public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {
        int countB = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else {
                deletions = Math.min(deletions + 1, countB);
            }
        }

        return deletions;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringBalanced solver =
                new MinimumDeletionsToMakeStringBalanced();

        // Test 1
        String s1 = "aababbab";
        System.out.println(solver.minimumDeletions(s1)); // 2

        // Test 2
        String s2 = "bbaaaaabb";
        System.out.println(solver.minimumDeletions(s2)); // 2

        // Test 3
        String s3 = "aaaa";
        System.out.println(solver.minimumDeletions(s3)); // 0

        // Test 4
        String s4 = "bbbb";
        System.out.println(solver.minimumDeletions(s4)); // 0

        // Test 5
        String s5 = "ba";
        System.out.println(solver.minimumDeletions(s5)); // 1
    }
}
