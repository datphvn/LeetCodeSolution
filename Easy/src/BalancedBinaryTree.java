public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNodeBalancedBinaryTree root) {
        return height(root) != -1;
    }

    private static int height(TreeNodeBalancedBinaryTree node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == -1) return -1;

        int right = height(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        // Example 1: [3,9,20,null,null,15,7] → true
        TreeNodeBalancedBinaryTree root1 = new TreeNodeBalancedBinaryTree(3,
                new TreeNodeBalancedBinaryTree(9),
                new TreeNodeBalancedBinaryTree(20,
                        new TreeNodeBalancedBinaryTree(15),
                        new TreeNodeBalancedBinaryTree(7))
        );
        System.out.println("Example 1 → " + isBalanced(root1));

        // Example 2: [1,2,2,3,3,null,null,4,4] → false
        TreeNodeBalancedBinaryTree root2 = new TreeNodeBalancedBinaryTree(1,
                new TreeNodeBalancedBinaryTree(2,
                        new TreeNodeBalancedBinaryTree(3,
                                new TreeNodeBalancedBinaryTree(4),
                                new TreeNodeBalancedBinaryTree(4)),
                        new TreeNodeBalancedBinaryTree(3)),
                new TreeNodeBalancedBinaryTree(2)
        );
        System.out.println("Example 2 → " + isBalanced(root2));

        // Example 3: [] → true
        System.out.println("Example 3 → " + isBalanced(null));
    }
}


class TreeNodeBalancedBinaryTree {
    int val;
    TreeNodeBalancedBinaryTree left;
    TreeNodeBalancedBinaryTree right;
    TreeNodeBalancedBinaryTree() {}
    TreeNodeBalancedBinaryTree(int val) { this.val = val; }
    TreeNodeBalancedBinaryTree(int val, TreeNodeBalancedBinaryTree left, TreeNodeBalancedBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
