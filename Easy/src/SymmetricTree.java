import java.util.*;

public class SymmetricTree {
    // Hàm chính để kiểm tra đối xứng
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // Đệ quy kiểm tra 2 cây con có phải ảnh gương không
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // Node cơ bản của cây
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Test case
    public static void main(String[] args) {
        SymmetricTree solver = new SymmetricTree();

        // Test 1: [1,2,2,3,4,4,3] -> true
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        System.out.println(solver.isSymmetric(root1)); // true

        // Test 2: [1,2,2,null,3,null,3] -> false
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println(solver.isSymmetric(root2)); // false
    }
}
