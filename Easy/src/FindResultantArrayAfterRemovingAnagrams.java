import java.util.*;

public class FindResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i], result.get(result.size() - 1))) {
                result.add(words[i]);
            }
        }

        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] count = new int[26];
        for (char c : a.toCharArray()) count[c - 'a']++;
        for (char c : b.toCharArray()) count[c - 'a']--;
        for (int x : count) if (x != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        FindResultantArrayAfterRemovingAnagrams solver = new FindResultantArrayAfterRemovingAnagrams();

        // Test 1
        String[] words1 = {"abba","baba","bbaa","cd","cd"};
        System.out.println(solver.removeAnagrams(words1)); // ["abba", "cd"]

        // Test 2
        String[] words2 = {"a","b","c","d","e"};
        System.out.println(solver.removeAnagrams(words2)); // ["a", "b", "c", "d", "e"]

        // Test 3
        String[] words3 = {"abc","cab","bac","xyz"};
        System.out.println(solver.removeAnagrams(words3)); // ["abc", "xyz"]

        // Test 4
        String[] words4 = {"aa","aa","aa"};
        System.out.println(solver.removeAnagrams(words4)); // ["aa"]
    }
}
