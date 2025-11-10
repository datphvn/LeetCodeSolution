import java.util.*;

public class MinimumOperationsToConvertAllElementsToZero {

    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operations = 0;

        for (int num : nums) {
            if (num == 0) {
                stack.clear();
            } else {
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < num) {
                    stack.push(num);
                    operations++;
                }
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        MinimumOperationsToConvertAllElementsToZero solver = new MinimumOperationsToConvertAllElementsToZero();

        System.out.println(solver.minOperations(new int[]{0,2}));           // 1
        System.out.println(solver.minOperations(new int[]{3,1,2,1}));      // 3
        System.out.println(solver.minOperations(new int[]{1,2,1,2,1,2}));  // 4
        System.out.println(solver.minOperations(new int[]{0,0,0}));        // 0
        System.out.println(solver.minOperations(new int[]{5,5,0,5,5}));    // 2
    }
}
