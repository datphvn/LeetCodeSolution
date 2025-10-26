public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solver = new ValidPalindrome();

        // Test 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(solver.isPalindrome(s1)); // ✅ true

        // Test 2
        String s2 = "race a car";
        System.out.println(solver.isPalindrome(s2)); // ✅ false

        // Test 3
        String s3 = " ";
        System.out.println(solver.isPalindrome(s3)); // ✅ true

        // Test 4
        String s4 = "No lemon, no melon";
        System.out.println(solver.isPalindrome(s4)); // ✅ true

        // Test 5
        String s5 = "12321";
        System.out.println(solver.isPalindrome(s5)); // ✅ true
    }
}
