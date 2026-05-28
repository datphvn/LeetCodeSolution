import java.util.*;

public class LongestCommonSuffixQueries {

    class TrieNodeLongestCommonSuffixQueries {

        TrieNodeLongestCommonSuffixQueries[] children =
                new TrieNodeLongestCommonSuffixQueries[26];

        int bestLen = Integer.MAX_VALUE;
        int bestIdx = Integer.MAX_VALUE;
    }

    public int[] stringIndices(String[] wordsContainer,
                               String[] wordsQuery) {

        TrieNodeLongestCommonSuffixQueries root =
                new TrieNodeLongestCommonSuffixQueries();

        // Build Trie
        for (int i = 0; i < wordsContainer.length; i++) {

            String word = wordsContainer[i];
            int len = word.length();

            TrieNodeLongestCommonSuffixQueries curr = root;

            // Update root info
            if (len < curr.bestLen ||
                    (len == curr.bestLen && i < curr.bestIdx)) {

                curr.bestLen = len;
                curr.bestIdx = i;
            }

            // Insert reversed word
            for (int j = len - 1; j >= 0; j--) {

                int charIdx = word.charAt(j) - 'a';

                if (curr.children[charIdx] == null) {
                    curr.children[charIdx] =
                            new TrieNodeLongestCommonSuffixQueries();
                }

                curr = curr.children[charIdx];

                if (len < curr.bestLen ||
                        (len == curr.bestLen && i < curr.bestIdx)) {

                    curr.bestLen = len;
                    curr.bestIdx = i;
                }
            }
        }

        int[] ans = new int[wordsQuery.length];

        // Query Trie
        for (int i = 0; i < wordsQuery.length; i++) {

            String query = wordsQuery[i];

            TrieNodeLongestCommonSuffixQueries curr = root;

            for (int j = query.length() - 1; j >= 0; j--) {

                int charIdx = query.charAt(j) - 'a';

                if (curr.children[charIdx] == null) {
                    break;
                }

                curr = curr.children[charIdx];
            }

            ans[i] = curr.bestIdx;
        }

        return ans;
    }

    public static void main(String[] args) {

        LongestCommonSuffixQueries solver =
                new LongestCommonSuffixQueries();

        // Test 1
        String[] wordsContainer1 =
                {"abcd", "bcd", "xbcd"};

        String[] wordsQuery1 =
                {"cd", "bcd", "xyz"};

        System.out.println(
                Arrays.toString(
                        solver.stringIndices(
                                wordsContainer1,
                                wordsQuery1
                        )
                )
        );
        // [1, 1, 1]

        // Test 2
        String[] wordsContainer2 =
                {"abcdefgh", "poiuygh", "ghghgh"};

        String[] wordsQuery2 =
                {"gh", "acbfgh", "acbfegh"};

        System.out.println(
                Arrays.toString(
                        solver.stringIndices(
                                wordsContainer2,
                                wordsQuery2
                        )
                )
        );
        // [2, 0, 2]

        // Test 3
        String[] wordsContainer3 =
                {"a", "aa", "aaa"};

        String[] wordsQuery3 =
                {"a", "ba", "c"};

        System.out.println(
                Arrays.toString(
                        solver.stringIndices(
                                wordsContainer3,
                                wordsQuery3
                        )
                )
        );
        // [0, 0, 0]
    }
}