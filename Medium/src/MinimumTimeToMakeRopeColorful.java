public class MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful solver = new MinimumTimeToMakeRopeColorful();

        // Test 1
        String colors1 = "abaac";
        int[] time1 = {1, 2, 3, 4, 5};
        System.out.println(solver.minCost(colors1, time1)); // Output: 3

        // Test 2
        String colors2 = "abc";
        int[] time2 = {1, 2, 3};
        System.out.println(solver.minCost(colors2, time2)); // Output: 0

        // Test 3
        String colors3 = "aabaa";
        int[] time3 = {1, 2, 3, 4, 1};
        System.out.println(solver.minCost(colors3, time3)); // Output: 2
    }
}
