public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWordSolution sol = new LengthOfLastWordSolution();

        // Test 1
        String s1 = "Hello World";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + sol.lengthOfLastWord(s1)); // 5

        // Test 2
        String s2 = "   fly me   to   the moon  ";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + sol.lengthOfLastWord(s2)); // 4

        // Test 3
        String s3 = "luffy is still joyboy";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + sol.lengthOfLastWord(s3)); // 6
    }
}

class LengthOfLastWordSolution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }
}
