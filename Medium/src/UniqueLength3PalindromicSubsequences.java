public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        int count = 0;

        for (int c = 0; c < 26; c++) {
            if (first[c] != -1 && last[c] > first[c]) {
                boolean[] mid = new boolean[26];
                for (int i = first[c] + 1; i < last[c]; i++) {
                    mid[s.charAt(i) - 'a'] = true;
                }
                for (boolean ok : mid) {
                    if (ok) count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        UniqueLength3PalindromicSubsequences solver = new UniqueLength3PalindromicSubsequences();

        // Testcases
        System.out.println(solver.countPalindromicSubsequence("aabca"));     // 3
        System.out.println(solver.countPalindromicSubsequence("adc"));       // 0
        System.out.println(solver.countPalindromicSubsequence("bbcbaba"));   // 4
    }
}
