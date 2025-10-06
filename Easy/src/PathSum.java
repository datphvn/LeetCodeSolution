import java.util.*;

public class PathSum {
    // DFS Recursive
    public boolean hasPathSumDFS(TreeNodePathSum root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSumDFS(root.left, targetSum - root.val)
                || hasPathSumDFS(root.right, targetSum - root.val);
    }

    // BFS Iterative
    public boolean hasPathSumBFS(TreeNodePathSum root, int targetSum) {
        if (root == null) return false;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, root.val));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNodePathSum node = p.node;
            int sum = p.sum;

            if (node.left == null && node.right == null && sum == targetSum)
                return true;

            if (node.left != null) q.add(new Pair(node.left, sum + node.left.val));
            if (node.right != null) q.add(new Pair(node.right, sum + node.right.val));
        }

        return false;
    }

    static class Pair {
        TreeNodePathSum node;
        int sum;
        Pair(TreeNodePathSum n, int s) { node = n; sum = s; }
    }

    public static void main(String[] args) {
        PathSum solver = new PathSum();

        // Test 1
        TreeNodePathSum root1 = new TreeNodePathSum(5,
                new TreeNodePathSum(4,
                        new TreeNodePathSum(11, new TreeNodePathSum(7), new TreeNodePathSum(2)),
                        null),
                new TreeNodePathSum(8,
                        new TreeNodePathSum(13),
                        new TreeNodePathSum(4, null, new TreeNodePathSum(1)))
        );
        System.out.println(solver.hasPathSumDFS(root1, 22)); // true
        System.out.println(solver.hasPathSumBFS(root1, 22)); // true

        // Test 2
        TreeNodePathSum root2 = new TreeNodePathSum(1,
                new TreeNodePathSum(2),
                new TreeNodePathSum(3)
        );
        System.out.println(solver.hasPathSumDFS(root2, 5)); // false
        System.out.println(solver.hasPathSumBFS(root2, 5)); // false

        // Test 3
        System.out.println(solver.hasPathSumDFS(null, 0)); // false
        System.out.println(solver.hasPathSumBFS(null, 0)); // false
    }
}

class TreeNodePathSum {
    int val;
    TreeNodePathSum left;
    TreeNodePathSum right;
    TreeNodePathSum() {}
    TreeNodePathSum(int val) { this.val = val; }
    TreeNodePathSum(int val, TreeNodePathSum left, TreeNodePathSum right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
