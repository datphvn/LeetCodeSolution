import java.util.*;

public class PascalTriangleII {
    // Cách 1: Sinh từng hàng
    public List<Integer> getRowGenerate(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < i; j++) {
                newRow.add(row.get(j - 1) + row.get(j));
            }
            newRow.add(1);
            row = newRow;
        }
        return row;
    }

    // Cách 2: Công thức tổ hợp
    public List<Integer> getRowCombination(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) val);
            val = val * (rowIndex - k) / (k + 1);
        }
        return row;
    }

    public static void main(String[] args) {
        PascalTriangleII solver = new PascalTriangleII();

        // Test 1: rowIndex = 3 -> [1,3,3,1]
        System.out.println(solver.getRowGenerate(3));      // [1, 3, 3, 1]
        System.out.println(solver.getRowCombination(3));   // [1, 3, 3, 1]

        // Test 2: rowIndex = 0 -> [1]
        System.out.println(solver.getRowGenerate(0));      // [1]
        System.out.println(solver.getRowCombination(0));   // [1]

        // Test 3: rowIndex = 1 -> [1,1]
        System.out.println(solver.getRowGenerate(1));      // [1, 1]
        System.out.println(solver.getRowCombination(1));   // [1, 1]
    }
}
