import java.util.*;

public class InvertBinaryTree {

    // DFS recursive
    public TreeNodeInvertBinaryTree invertTree(TreeNodeInvertBinaryTree root) {
        if (root == null) return null;

        TreeNodeInvertBinaryTree left = invertTree(root.left);
        TreeNodeInvertBinaryTree right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // BFS iterative
    public TreeNodeInvertBinaryTree invertTreeBFS(TreeNodeInvertBinaryTree root) {
        if (root == null) return null;

        Queue<TreeNodeInvertBinaryTree> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNodeInvertBinaryTree cur = q.poll();

            // swap
            TreeNodeInvertBinaryTree temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }

        return root;
    }

    // -------- MAIN TEST ----------
    public static void main(String[] args) {
        InvertBinaryTree solver = new InvertBinaryTree();

        // Tree: [4,2,7,1,3,6,9]
        TreeNodeInvertBinaryTree root = new TreeNodeInvertBinaryTree(4,
                new TreeNodeInvertBinaryTree(2,
                        new TreeNodeInvertBinaryTree(1),
                        new TreeNodeInvertBinaryTree(3)
                ),
                new TreeNodeInvertBinaryTree(7,
                        new TreeNodeInvertBinaryTree(6),
                        new TreeNodeInvertBinaryTree(9)
                )
        );

        TreeNodeInvertBinaryTree inverted = solver.invertTree(root);
        System.out.println("Root after invert: " + inverted.val); // 4
    }
}

class TreeNodeInvertBinaryTree {
    int val;
    TreeNodeInvertBinaryTree left;
    TreeNodeInvertBinaryTree right;

    TreeNodeInvertBinaryTree() {}
    TreeNodeInvertBinaryTree(int val) { this.val = val; }
    TreeNodeInvertBinaryTree(int val, TreeNodeInvertBinaryTree left, TreeNodeInvertBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
