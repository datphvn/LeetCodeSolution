public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber solver = new ExcelSheetColumnNumber();

        // Test 1
        System.out.println(solver.titleToNumber("A"));   // Output: 1

        // Test 2
        System.out.println(solver.titleToNumber("AB"));  // Output: 28

        // Test 3
        System.out.println(solver.titleToNumber("ZY"));  // Output: 701

        // Test 4
        System.out.println(solver.titleToNumber("FXSHRXW")); // Output: 2147483647 (max int)
    }
}
