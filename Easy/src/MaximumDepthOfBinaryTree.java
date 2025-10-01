import java.util.*;

public class MaximumDepthOfBinaryTree {
    // DFS Recursive
    public int maxDepth(TreeNodeMaximumDepthOfBinaryTree root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // BFS Iterative
    public int maxDepthBFS(TreeNodeMaximumDepthOfBinaryTree root) {
        if (root == null) return 0;
        Queue<TreeNodeMaximumDepthOfBinaryTree> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNodeMaximumDepthOfBinaryTree node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solver = new MaximumDepthOfBinaryTree();

        // Test 1: [3,9,20,null,null,15,7] -> 3
        TreeNodeMaximumDepthOfBinaryTree root1 = new TreeNodeMaximumDepthOfBinaryTree(3,
                new TreeNodeMaximumDepthOfBinaryTree(9),
                new TreeNodeMaximumDepthOfBinaryTree(20, new TreeNodeMaximumDepthOfBinaryTree(15), new TreeNodeMaximumDepthOfBinaryTree(7))
        );
        System.out.println(solver.maxDepth(root1));    // 3
        System.out.println(solver.maxDepthBFS(root1)); // 3

        // Test 2: [1,null,2] -> 2
        TreeNodeMaximumDepthOfBinaryTree root2 = new TreeNodeMaximumDepthOfBinaryTree(1, null, new TreeNodeMaximumDepthOfBinaryTree(2));
        System.out.println(solver.maxDepth(root2));    // 2
        System.out.println(solver.maxDepthBFS(root2)); // 2

        // Test 3: [] -> 0
        System.out.println(solver.maxDepth(null));    // 0
        System.out.println(solver.maxDepthBFS(null)); // 0
    }
}

// chỉ là class phụ, KHÔNG public
class TreeNodeMaximumDepthOfBinaryTree {
    int val;
    TreeNodeMaximumDepthOfBinaryTree left;
    TreeNodeMaximumDepthOfBinaryTree right;

    TreeNodeMaximumDepthOfBinaryTree() {}
    TreeNodeMaximumDepthOfBinaryTree(int val) { this.val = val; }
    TreeNodeMaximumDepthOfBinaryTree(int val, TreeNodeMaximumDepthOfBinaryTree left, TreeNodeMaximumDepthOfBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
