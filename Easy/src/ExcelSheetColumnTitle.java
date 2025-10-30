public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // chuyển từ 1–26 sang 0–25
            int remainder = columnNumber % 26;
            sb.append((char) ('A' + remainder));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle solver = new ExcelSheetColumnTitle();

        System.out.println(solver.convertToTitle(1));   // A
        System.out.println(solver.convertToTitle(26));  // Z
        System.out.println(solver.convertToTitle(27));  // AA
        System.out.println(solver.convertToTitle(28));  // AB
        System.out.println(solver.convertToTitle(701)); // ZY
        System.out.println(solver.convertToTitle(702)); // ZZ
        System.out.println(solver.convertToTitle(703)); // AAA
    }
}
