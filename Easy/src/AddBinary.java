public class AddBinary {
    public static void main(String[] args) {
        AddBinarySolution sol = new AddBinarySolution();

        // Test 1
        String a1 = "11", b1 = "1";
        System.out.println("Input: a=" + a1 + ", b=" + b1 +
                " -> Output: " + sol.addBinary(a1, b1)); // 100

        // Test 2
        String a2 = "1010", b2 = "1011";
        System.out.println("Input: a=" + a2 + ", b=" + b2 +
                " -> Output: " + sol.addBinary(a2, b2)); // 10101

        // Test 3
        String a3 = "0", b3 = "0";
        System.out.println("Input: a=" + a3 + ", b=" + b3 +
                " -> Output: " + sol.addBinary(a3, b3)); // 0

        // Test 4
        String a4 = "1111", b4 = "1111";
        System.out.println("Input: a=" + a4 + ", b=" + b4 +
                " -> Output: " + sol.addBinary(a4, b4)); // 11110
    }
}

class AddBinarySolution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }
}
