import java.util.*;

public class SeparateSquaresII {

    static class EventSeparateSquaresII {
        long y, x1, x2;
        int type; // +1 add, -1 remove

        EventSeparateSquaresII(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        List<EventSeparateSquaresII> events = new ArrayList<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new EventSeparateSquaresII(y, x, x + l, +1));
            events.add(new EventSeparateSquaresII(y + l, x, x + l, -1));
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        TreeMap<Long, Integer> active = new TreeMap<>();
        List<long[]> strips = new ArrayList<>();

        long prevY = events.get(0).y;
        double totalArea = 0;

        for (EventSeparateSquaresII e : events) {
            long currY = e.y;
            if (currY > prevY) {
                double width = unionX(active);
                if (width > 0) {
                    double area = width * (currY - prevY);
                    strips.add(new long[]{
                            prevY,
                            currY,
                            Double.doubleToLongBits(width),
                            Double.doubleToLongBits(totalArea)
                    });
                    totalArea += area;
                }
            }

            active.put(e.x1, active.getOrDefault(e.x1, 0) + e.type);
            active.put(e.x2, active.getOrDefault(e.x2, 0) - e.type);
            if (active.get(e.x1) == 0) active.remove(e.x1);
            if (active.get(e.x2) == 0) active.remove(e.x2);

            prevY = currY;
        }

        double half = totalArea / 2;

        for (long[] s : strips) {
            long y1 = s[0], y2 = s[1];
            double width = Double.longBitsToDouble(s[2]);
            double areaBefore = Double.longBitsToDouble(s[3]);
            double stripArea = width * (y2 - y1);

            if (areaBefore + stripArea >= half) {
                return y1 + (half - areaBefore) / width;
            }
        }

        return prevY;
    }

    private double unionX(TreeMap<Long, Integer> map) {
        long prev = 0;
        int cnt = 0;
        double len = 0;

        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            long x = e.getKey();
            if (cnt > 0) {
                len += x - prev;
            }
            cnt += e.getValue();
            prev = x;
        }
        return len;
    }

    // ================== MAIN TEST ==================
    public static void main(String[] args) {
        SeparateSquaresII solver = new SeparateSquaresII();

        int[][] test1 = {{0,0,1},{2,2,1}};
        System.out.println(solver.separateSquares(test1)); // ~1.0

        int[][] test2 = {{0,0,2},{1,1,1}};
        System.out.println(solver.separateSquares(test2)); // ~1.0

        int[][] test3 = {{15,21,2},{19,21,3}};
        System.out.println(solver.separateSquares(test3)); // ~22.3
    }
}
