import java.util.*;

public class MinimumDepthOfBinaryTree {
    // DFS Recursive
    public int minDepth(TreeNodeMinimumDepthOfBinaryTree root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // BFS Iterative
    public int minDepthBFS(TreeNodeMinimumDepthOfBinaryTree root) {
        if (root == null) return 0;
        Queue<TreeNodeMinimumDepthOfBinaryTree> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNodeMinimumDepthOfBinaryTree node = q.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree solver = new MinimumDepthOfBinaryTree();

        // Test 1: [3,9,20,null,null,15,7] -> 2
        TreeNodeMinimumDepthOfBinaryTree root1 = new TreeNodeMinimumDepthOfBinaryTree(3,
                new TreeNodeMinimumDepthOfBinaryTree(9),
                new TreeNodeMinimumDepthOfBinaryTree(20,
                        new TreeNodeMinimumDepthOfBinaryTree(15),
                        new TreeNodeMinimumDepthOfBinaryTree(7))
        );
        System.out.println(solver.minDepth(root1));   // 2
        System.out.println(solver.minDepthBFS(root1)); // 2

        // Test 2: [2,null,3,null,4,null,5,null,6] -> 5
        TreeNodeMinimumDepthOfBinaryTree root2 = new TreeNodeMinimumDepthOfBinaryTree(2,
                null,
                new TreeNodeMinimumDepthOfBinaryTree(3,
                        null,
                        new TreeNodeMinimumDepthOfBinaryTree(4,
                                null,
                                new TreeNodeMinimumDepthOfBinaryTree(5,
                                        null,
                                        new TreeNodeMinimumDepthOfBinaryTree(6)
                                )
                        )
                )
        );
        System.out.println(solver.minDepth(root2));   // 5
        System.out.println(solver.minDepthBFS(root2)); // 5

        // Test 3: [] -> 0
        System.out.println(solver.minDepth(null));   // 0
        System.out.println(solver.minDepthBFS(null)); // 0
    }
}


class TreeNodeMinimumDepthOfBinaryTree {
    int val;
    TreeNodeMinimumDepthOfBinaryTree left;
    TreeNodeMinimumDepthOfBinaryTree right;
    TreeNodeMinimumDepthOfBinaryTree() {}
    TreeNodeMinimumDepthOfBinaryTree(int val) { this.val = val; }
    TreeNodeMinimumDepthOfBinaryTree(int val, TreeNodeMinimumDepthOfBinaryTree left, TreeNodeMinimumDepthOfBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
