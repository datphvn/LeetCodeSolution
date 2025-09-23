public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";

        FindTheIndexOfTheFirstOccurrenceInAStringSolution sol =
                new FindTheIndexOfTheFirstOccurrenceInAStringSolution();
        int result = sol.strStr(haystack, needle);

        System.out.println("haystack = \"" + haystack + "\"");
        System.out.println("needle = \"" + needle + "\"");
        System.out.println("Output (index) = " + result);
    }
}

class FindTheIndexOfTheFirstOccurrenceInAStringSolution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
