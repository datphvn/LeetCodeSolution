import java.util.*;

public class BinaryTreePreorderTraversal {
    // DFS Recursive
    public List<Integer> preorderTraversalRecursive(TreeNodeBinaryTreePreorderTraversal root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNodeBinaryTreePreorderTraversal node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        dfs(node.left, result);
        dfs(node.right, result);
    }

    // Iterative using Stack
    public List<Integer> preorderTraversalIterative(TreeNodeBinaryTreePreorderTraversal root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNodeBinaryTreePreorderTraversal> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNodeBinaryTreePreorderTraversal node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreePreorderTraversal solver = new BinaryTreePreorderTraversal();

        // Test 1: [1, null, 2, 3] -> [1, 2, 3]
        TreeNodeBinaryTreePreorderTraversal root1 = new TreeNodeBinaryTreePreorderTraversal(1, null,
                new TreeNodeBinaryTreePreorderTraversal(2,
                        new TreeNodeBinaryTreePreorderTraversal(3), null));
        System.out.println(solver.preorderTraversalRecursive(root1)); // [1, 2, 3]
        System.out.println(solver.preorderTraversalIterative(root1)); // [1, 2, 3]

        // Test 2: [1,2,3,4,5,null,8,null,null,6,7,9]
        TreeNodeBinaryTreePreorderTraversal root2 = new TreeNodeBinaryTreePreorderTraversal(1,
                new TreeNodeBinaryTreePreorderTraversal(2,
                        new TreeNodeBinaryTreePreorderTraversal(4),
                        new TreeNodeBinaryTreePreorderTraversal(5,
                                new TreeNodeBinaryTreePreorderTraversal(6),
                                new TreeNodeBinaryTreePreorderTraversal(7))),
                new TreeNodeBinaryTreePreorderTraversal(3, null,
                        new TreeNodeBinaryTreePreorderTraversal(8,
                                new TreeNodeBinaryTreePreorderTraversal(9), null)));
        System.out.println(solver.preorderTraversalRecursive(root2)); // [1,2,4,5,6,7,3,8,9]

        // Test 3: [] -> []
        System.out.println(solver.preorderTraversalRecursive(null)); // []

        // Test 4: [1] -> [1]
        TreeNodeBinaryTreePreorderTraversal root4 = new TreeNodeBinaryTreePreorderTraversal(1);
        System.out.println(solver.preorderTraversalIterative(root4)); // [1]
    }
}

class TreeNodeBinaryTreePreorderTraversal {
    int val;
    TreeNodeBinaryTreePreorderTraversal left;
    TreeNodeBinaryTreePreorderTraversal right;

    TreeNodeBinaryTreePreorderTraversal(int val) {
        this.val = val;
    }

    TreeNodeBinaryTreePreorderTraversal(int val, TreeNodeBinaryTreePreorderTraversal left, TreeNodeBinaryTreePreorderTraversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
