public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        int maxDigit = 0;

        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
            if (maxDigit == 9) return 9;
        }

        return maxDigit;
    }

    public static void main(String[] args) {
        PartitioningIntoMinimumNumberOfDeciBinaryNumbers solver =
                new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();

        // Test 1: "32" -> 3
        System.out.println(solver.minPartitions("32")); // 3

        // Test 2: "82734" -> 8
        System.out.println(solver.minPartitions("82734")); // 8

        // Test 3: "27346209830709182346" -> 9
        System.out.println(solver.minPartitions("27346209830709182346")); // 9
    }
}