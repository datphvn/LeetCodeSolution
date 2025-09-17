public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solver = new LongestCommonPrefix();

        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};

        System.out.println(java.util.Arrays.toString(strs1)
                + " -> " + solver.longestCommonPrefix(strs1)); // "fl"
        System.out.println(java.util.Arrays.toString(strs2)
                + " -> " + solver.longestCommonPrefix(strs2)); // ""
    }
}
