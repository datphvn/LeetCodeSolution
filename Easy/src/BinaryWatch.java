import java.util.*;

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    result.add(hour + ":" + String.format("%02d", minute));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryWatch solver = new BinaryWatch();

        // Test 1
        System.out.println(solver.readBinaryWatch(1));
        // Expected: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

        // Test 2
        System.out.println(solver.readBinaryWatch(9));
        // Expected: []
    }
}
