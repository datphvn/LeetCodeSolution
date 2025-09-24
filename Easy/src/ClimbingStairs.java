public class ClimbingStairs {
    public static void main(String[] args) {
        SolutionClimbingStairs sol = new SolutionClimbingStairs();

        int n1 = 2;
        System.out.println("Input: " + n1 + " → Output: " + sol.climbStairs(n1));

        int n2 = 3;
        System.out.println("Input: " + n2 + " → Output: " + sol.climbStairs(n2));

        int n3 = 5;
        System.out.println("Input: " + n3 + " → Output: " + sol.climbStairs(n3));
    }
}

class SolutionClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
