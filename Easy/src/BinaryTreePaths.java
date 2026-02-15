import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNodeBinaryTreePaths root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNodeBinaryTreePaths node, String path, List<String> result) {
        if (node == null) return;

        if (!path.isEmpty()) {
            path += "->";
        }
        path += node.val;

        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }

    public static void main(String[] args) {
        BinaryTreePaths solver = new BinaryTreePaths();

        // Test 1: [1,2,3,null,5] -> ["1->2->5","1->3"]
        TreeNodeBinaryTreePaths root1 = new TreeNodeBinaryTreePaths(1,
                new TreeNodeBinaryTreePaths(2, null,
                        new TreeNodeBinaryTreePaths(5)
                ),
                new TreeNodeBinaryTreePaths(3)
        );
        System.out.println(solver.binaryTreePaths(root1));

        // Test 2: [1] -> ["1"]
        TreeNodeBinaryTreePaths root2 = new TreeNodeBinaryTreePaths(1);
        System.out.println(solver.binaryTreePaths(root2));
    }
}

class TreeNodeBinaryTreePaths {
    int val;
    TreeNodeBinaryTreePaths left;
    TreeNodeBinaryTreePaths right;

    TreeNodeBinaryTreePaths() {}

    TreeNodeBinaryTreePaths(int val) {
        this.val = val;
    }

    TreeNodeBinaryTreePaths(int val, TreeNodeBinaryTreePaths left, TreeNodeBinaryTreePaths right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
