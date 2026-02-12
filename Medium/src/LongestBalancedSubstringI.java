public class LongestBalancedSubstringI {

    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private boolean isBalanced(int[] freq) {
        int target = 0;

        for (int count : freq) {
            if (count > 0) {
                if (target == 0) {
                    target = count;
                } else if (count != target) {
                    return false;
                }
            }
        }

        return target > 0;
    }

    public static void main(String[] args) {
        LongestBalancedSubstringI solver = new LongestBalancedSubstringI();

        String s1 = "abbac";
        System.out.println(solver.longestBalanced(s1)); // 4

        String s2 = "zzabccy";
        System.out.println(solver.longestBalanced(s2)); // 4

        String s3 = "aba";
        System.out.println(solver.longestBalanced(s3)); // 2

        String s4 = "aaaa";
        System.out.println(solver.longestBalanced(s4)); // 4
    }
}
