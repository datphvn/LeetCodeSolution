import java.util.*;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // first element always 1

            // compute inner
            for (int j = 1; j < i; j++) {
                int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(val);
            }

            if (i > 0) row.add(1); // last element also 1 (except first row)
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle solver = new PascalsTriangle();
        System.out.println(solver.generate(5));
        System.out.println(solver.generate(1));

    }
}
