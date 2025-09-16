class Solution {
    public boolean isPalindrome(int x) {
        // Các số âm hoặc số kết thúc bằng 0 (trừ 0) thì không phải palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            // lấy chữ số cuối và thêm vào reversedHalf
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Nếu x == reversedHalf (số chẵn chữ số) hoặc x == reversedHalf/10 (số lẻ chữ số)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
