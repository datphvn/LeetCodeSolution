import java.util.*;

public class AppleRedistributionIntoBoxes {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        Arrays.sort(capacity);

        int currentCapacity = 0;
        int boxes = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            boxes++;
            if (currentCapacity >= totalApples) {
                break;
            }
        }

        return boxes;
    }

    public static void main(String[] args) {
        AppleRedistributionIntoBoxes solver = new AppleRedistributionIntoBoxes();

        // Test 1
        int[] apple1 = {1, 3, 2};
        int[] capacity1 = {4, 3, 1, 5, 2};
        System.out.println(solver.minimumBoxes(apple1, capacity1)); // 2

        // Test 2
        int[] apple2 = {5, 5, 5};
        int[] capacity2 = {2, 4, 2, 7};
        System.out.println(solver.minimumBoxes(apple2, capacity2)); // 4
    }
}
