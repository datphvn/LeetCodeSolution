public class ShortestDistanceToTargetStringInACircularArray {

    public int closestTarget(String[] words, String target, int start) {
        int n = words.length;

        for (int i = 0; i <= n / 2; i++) {
            if (words[(start + i) % n].equals(target) ||
                    words[(start - i + n) % n].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestDistanceToTargetStringInACircularArray solver =
                new ShortestDistanceToTargetStringInACircularArray();

        // Test 1
        String[] words1 = {"hello","i","am","leetcode","hello"};
        System.out.println(solver.closestTarget(words1, "hello", 1)); // 1

        // Test 2
        String[] words2 = {"a","b","leetcode"};
        System.out.println(solver.closestTarget(words2, "leetcode", 0)); // 1

        // Test 3
        String[] words3 = {"i","eat","leetcode"};
        System.out.println(solver.closestTarget(words3, "ate", 0)); // -1
    }
}