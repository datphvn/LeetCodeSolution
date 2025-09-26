import java.util.*;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        // Tạo cây: [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        SolutionBinaryTreeInorder sol = new SolutionBinaryTreeInorder();
        List<Integer> result = sol.inorderTraversal(root);

        System.out.println(result); // [1, 3, 2]
    }
}

class SolutionBinaryTreeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
