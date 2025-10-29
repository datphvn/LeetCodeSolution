import java.util.*;

public class BinaryTreePostorderTraversal {
    // Recursive
    public List<Integer> postorderTraversalRecursive(TreeNodeBinaryTreePostorderTraversal root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNodeBinaryTreePostorderTraversal node, List<Integer> result) {
        if (node == null) return;
        dfs(node.left, result);
        dfs(node.right, result);
        result.add(node.val);
    }

    // Iterative using 1 Stack (Reverse Preorder)
    public List<Integer> postorderTraversalIterative(TreeNodeBinaryTreePostorderTraversal root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNodeBinaryTreePostorderTraversal> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNodeBinaryTreePostorderTraversal node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal solver = new BinaryTreePostorderTraversal();

        // Test 1: [1, null, 2, 3] -> [3, 2, 1]
        TreeNodeBinaryTreePostorderTraversal root1 = new TreeNodeBinaryTreePostorderTraversal(1, null,
                new TreeNodeBinaryTreePostorderTraversal(2,
                        new TreeNodeBinaryTreePostorderTraversal(3), null));
        System.out.println(solver.postorderTraversalRecursive(root1)); // [3, 2, 1]
        System.out.println(solver.postorderTraversalIterative(root1)); // [3, 2, 1]

        // Test 2: [1,2,3,4,5,null,8,null,null,6,7,9]
        TreeNodeBinaryTreePostorderTraversal root2 = new TreeNodeBinaryTreePostorderTraversal(1,
                new TreeNodeBinaryTreePostorderTraversal(2,
                        new TreeNodeBinaryTreePostorderTraversal(4),
                        new TreeNodeBinaryTreePostorderTraversal(5,
                                new TreeNodeBinaryTreePostorderTraversal(6),
                                new TreeNodeBinaryTreePostorderTraversal(7))),
                new TreeNodeBinaryTreePostorderTraversal(3, null,
                        new TreeNodeBinaryTreePostorderTraversal(8,
                                new TreeNodeBinaryTreePostorderTraversal(9), null)));
        System.out.println(solver.postorderTraversalRecursive(root2)); // [4,6,7,5,2,9,8,3,1]
        System.out.println(solver.postorderTraversalIterative(root2)); // [4,6,7,5,2,9,8,3,1]

        // Test 3: [] -> []
        System.out.println(solver.postorderTraversalRecursive(null)); // []

        // Test 4: [1] -> [1]
        TreeNodeBinaryTreePostorderTraversal root4 = new TreeNodeBinaryTreePostorderTraversal(1);
        System.out.println(solver.postorderTraversalIterative(root4)); // [1]
    }
}

class TreeNodeBinaryTreePostorderTraversal {
    int val;
    TreeNodeBinaryTreePostorderTraversal left;
    TreeNodeBinaryTreePostorderTraversal right;

    TreeNodeBinaryTreePostorderTraversal(int val) {
        this.val = val;
    }

    TreeNodeBinaryTreePostorderTraversal(int val, TreeNodeBinaryTreePostorderTraversal left, TreeNodeBinaryTreePostorderTraversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
