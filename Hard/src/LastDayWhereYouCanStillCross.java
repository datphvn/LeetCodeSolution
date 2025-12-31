import java.util.*;

public class LastDayWhereYouCanStillCross {

    private int row, col;
    private int[][] cells;
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;
        this.cells = cells;

        int left = 1, right = cells.length;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int day) {
        int[][] grid = new int[row][col];

        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                q.add(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == row - 1) return true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col &&
                        !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LastDayWhereYouCanStillCross solver = new LastDayWhereYouCanStillCross();

        int[][] cells1 = {{1,1},{2,1},{1,2},{2,2}};
        System.out.println(solver.latestDayToCross(2, 2, cells1)); // 2

        int[][] cells2 = {{1,1},{1,2},{2,1},{2,2}};
        System.out.println(solver.latestDayToCross(2, 2, cells2)); // 1

        int[][] cells3 = {
                {1,2},{2,1},{3,3},{2,2},{1,1},
                {1,3},{2,3},{3,2},{3,1}
        };
        System.out.println(solver.latestDayToCross(3, 3, cells3)); // 3
    }
}
