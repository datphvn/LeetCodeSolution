import java.util.*;

public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNodeMaximumLevelSumOfBinaryTree root) {
        Queue<TreeNodeMaximumLevelSumOfBinaryTree> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNodeMaximumLevelSumOfBinaryTree node = q.poll();
                sum += node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        MaximumLevelSumOfBinaryTree solver = new MaximumLevelSumOfBinaryTree();

        // Test 1: [1,7,0,7,-8,null,null] -> 2
        TreeNodeMaximumLevelSumOfBinaryTree root1 =
                new TreeNodeMaximumLevelSumOfBinaryTree(1,
                        new TreeNodeMaximumLevelSumOfBinaryTree(7,
                                new TreeNodeMaximumLevelSumOfBinaryTree(7),
                                new TreeNodeMaximumLevelSumOfBinaryTree(-8)
                        ),
                        new TreeNodeMaximumLevelSumOfBinaryTree(0)
                );

        System.out.println(solver.maxLevelSum(root1)); // 2

        // Test 2: [989,null,10250,98693,-89388,null,null,null,-32127] -> 2
        TreeNodeMaximumLevelSumOfBinaryTree root2 =
                new TreeNodeMaximumLevelSumOfBinaryTree(989,
                        null,
                        new TreeNodeMaximumLevelSumOfBinaryTree(10250,
                                new TreeNodeMaximumLevelSumOfBinaryTree(98693,
                                        null,
                                        new TreeNodeMaximumLevelSumOfBinaryTree(-32127)
                                ),
                                new TreeNodeMaximumLevelSumOfBinaryTree(-89388)
                        )
                );

        System.out.println(solver.maxLevelSum(root2)); // 2
    }
}

class TreeNodeMaximumLevelSumOfBinaryTree {
    int val;
    TreeNodeMaximumLevelSumOfBinaryTree left;
    TreeNodeMaximumLevelSumOfBinaryTree right;

    TreeNodeMaximumLevelSumOfBinaryTree() {}

    TreeNodeMaximumLevelSumOfBinaryTree(int val) {
        this.val = val;
    }

    TreeNodeMaximumLevelSumOfBinaryTree(
            int val,
            TreeNodeMaximumLevelSumOfBinaryTree left,
            TreeNodeMaximumLevelSumOfBinaryTree right
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
