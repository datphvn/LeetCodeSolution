import java.util.*;

public class BalanceABinarySearchTree {

    public TreeNodeBalanceABinarySearchTree balanceBST(TreeNodeBalanceABinarySearchTree root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return buildBalancedBST(values, 0, values.size() - 1);
    }

    private void inorder(TreeNodeBalanceABinarySearchTree root, List<Integer> values) {
        if (root == null) return;
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

    private TreeNodeBalanceABinarySearchTree buildBalancedBST(
            List<Integer> values, int left, int right) {

        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNodeBalanceABinarySearchTree node =
                new TreeNodeBalanceABinarySearchTree(values.get(mid));
        node.left = buildBalancedBST(values, left, mid - 1);
        node.right = buildBalancedBST(values, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        BalanceABinarySearchTree solver = new BalanceABinarySearchTree();

        // Test 1: [1,null,2,null,3,null,4]
        TreeNodeBalanceABinarySearchTree root1 =
                new TreeNodeBalanceABinarySearchTree(1,
                        null,
                        new TreeNodeBalanceABinarySearchTree(2,
                                null,
                                new TreeNodeBalanceABinarySearchTree(3,
                                        null,
                                        new TreeNodeBalanceABinarySearchTree(4)
                                )
                        )
                );

        TreeNodeBalanceABinarySearchTree balanced1 = solver.balanceBST(root1);
        printInorder(balanced1);
        System.out.println();

        // Test 2: [2,1,3]
        TreeNodeBalanceABinarySearchTree root2 =
                new TreeNodeBalanceABinarySearchTree(2,
                        new TreeNodeBalanceABinarySearchTree(1),
                        new TreeNodeBalanceABinarySearchTree(3)
                );

        TreeNodeBalanceABinarySearchTree balanced2 = solver.balanceBST(root2);
        printInorder(balanced2);
        System.out.println();
    }

    private static void printInorder(TreeNodeBalanceABinarySearchTree root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

class TreeNodeBalanceABinarySearchTree {
    int val;
    TreeNodeBalanceABinarySearchTree left;
    TreeNodeBalanceABinarySearchTree right;
    TreeNodeBalanceABinarySearchTree() {}
    TreeNodeBalanceABinarySearchTree(int val) { this.val = val; }
    TreeNodeBalanceABinarySearchTree(
            int val,
            TreeNodeBalanceABinarySearchTree left,
            TreeNodeBalanceABinarySearchTree right
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
