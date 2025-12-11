import java.util.*;

public class CountCoveredBuildings {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rowMap.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            colMap.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        for (List<Integer> list : rowMap.values()) Collections.sort(list);
        for (List<Integer> list : colMap.values()) Collections.sort(list);

        int count = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            List<Integer> row = rowMap.get(x);
            List<Integer> col = colMap.get(y);

            int idxRow = Collections.binarySearch(row, y);
            int idxCol = Collections.binarySearch(col, x);

            boolean hasLeft = idxRow > 0;
            boolean hasRight = idxRow < row.size() - 1;
            boolean hasAbove = idxCol > 0;
            boolean hasBelow = idxCol < col.size() - 1;

            if (hasLeft && hasRight && hasAbove && hasBelow) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountCoveredBuildings solver = new CountCoveredBuildings();

        int[][] b1 = {{1,2},{2,2},{3,2},{2,1},{2,3}};
        System.out.println(solver.countCoveredBuildings(3, b1)); // 1

        int[][] b2 = {{1,1},{1,2},{2,1},{2,2}};
        System.out.println(solver.countCoveredBuildings(3, b2)); // 0

        int[][] b3 = {{1,3},{3,2},{3,3},{3,5},{5,3}};
        System.out.println(solver.countCoveredBuildings(5, b3)); // 1
    }
}
