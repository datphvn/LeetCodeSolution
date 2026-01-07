import java.util.*;

public class MaximumProductOfSplittedBinaryTree {

    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNodeMaximumProductOfSplittedBinaryTree root) {
        totalSum = getTotalSum(root);
        getSubtreeSum(root);
        return (int)(maxProduct % MOD);
    }

    private long getTotalSum(TreeNodeMaximumProductOfSplittedBinaryTree node) {
        if (node == null) return 0;
        return node.val
                + getTotalSum(node.left)
                + getTotalSum(node.right);
    }

    private long getSubtreeSum(TreeNodeMaximumProductOfSplittedBinaryTree node) {
        if (node == null) return 0;

        long left = getSubtreeSum(node.left);
        long right = getSubtreeSum(node.right);

        long subtreeSum = node.val + left + right;
        maxProduct = Math.max(maxProduct, subtreeSum * (totalSum - subtreeSum));

        return subtreeSum;
    }

    public static void main(String[] args) {
        MaximumProductOfSplittedBinaryTree solver =
                new MaximumProductOfSplittedBinaryTree();

        // Test 1: [1,2,3,4,5,6] -> 110
        TreeNodeMaximumProductOfSplittedBinaryTree root1 =
                new TreeNodeMaximumProductOfSplittedBinaryTree(1,
                        new TreeNodeMaximumProductOfSplittedBinaryTree(2,
                                new TreeNodeMaximumProductOfSplittedBinaryTree(4),
                                new TreeNodeMaximumProductOfSplittedBinaryTree(5)
                        ),
                        new TreeNodeMaximumProductOfSplittedBinaryTree(3,
                                new TreeNodeMaximumProductOfSplittedBinaryTree(6),
                                null
                        )
                );
        System.out.println(solver.maxProduct(root1)); // 110

        // Test 2: [1,null,2,3,4,null,null,5,6] -> 90
        TreeNodeMaximumProductOfSplittedBinaryTree root2 =
                new TreeNodeMaximumProductOfSplittedBinaryTree(1,
                        null,
                        new TreeNodeMaximumProductOfSplittedBinaryTree(2,
                                new TreeNodeMaximumProductOfSplittedBinaryTree(3,
                                        new TreeNodeMaximumProductOfSplittedBinaryTree(5),
                                        new TreeNodeMaximumProductOfSplittedBinaryTree(6)
                                ),
                                new TreeNodeMaximumProductOfSplittedBinaryTree(4)
                        )
                );
        System.out.println(solver.maxProduct(root2)); // 90
    }
}

class TreeNodeMaximumProductOfSplittedBinaryTree {
    int val;
    TreeNodeMaximumProductOfSplittedBinaryTree left;
    TreeNodeMaximumProductOfSplittedBinaryTree right;

    TreeNodeMaximumProductOfSplittedBinaryTree() {}

    TreeNodeMaximumProductOfSplittedBinaryTree(int val) {
        this.val = val;
    }

    TreeNodeMaximumProductOfSplittedBinaryTree(
            int val,
            TreeNodeMaximumProductOfSplittedBinaryTree left,
            TreeNodeMaximumProductOfSplittedBinaryTree right
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
