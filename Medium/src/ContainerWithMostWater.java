public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // Main test
    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();

        // Test 1
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(solver.maxArea(height1)); // 49

        // Test 2
        int[] height2 = {1,1};
        System.out.println(solver.maxArea(height2)); // 1

        // Test 3
        int[] height3 = {4,3,2,1,4};
        System.out.println(solver.maxArea(height3)); // 16
    }
}
