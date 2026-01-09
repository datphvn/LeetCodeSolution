import java.util.*;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNodeSmallestSubtreeWithAllTheDeepestNodes subtreeWithAllDeepest(
            TreeNodeSmallestSubtreeWithAllTheDeepestNodes root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNodeSmallestSubtreeWithAllTheDeepestNodes root) {
        if (root == null) {
            return new Result(0, null);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Result(left.depth + 1, root);
        } else if (left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        } else {
            return new Result(right.depth + 1, right.node);
        }
    }

    private static class Result {
        int depth;
        TreeNodeSmallestSubtreeWithAllTheDeepestNodes node;

        Result(int depth, TreeNodeSmallestSubtreeWithAllTheDeepestNodes node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        SmallestSubtreeWithAllTheDeepestNodes solver =
                new SmallestSubtreeWithAllTheDeepestNodes();

        // Example 1:
        // [3,5,1,6,2,0,8,null,null,7,4]
        TreeNodeSmallestSubtreeWithAllTheDeepestNodes root =
                new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(3,
                        new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(5,
                                new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(6),
                                new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(2,
                                        new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(7),
                                        new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(4)
                                )
                        ),
                        new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(1,
                                new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(0),
                                new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(8)
                        )
                );

        System.out.println(
                solver.subtreeWithAllDeepest(root).val
        ); // 2

        // Example 2: [1]
        TreeNodeSmallestSubtreeWithAllTheDeepestNodes root2 =
                new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(1);

        System.out.println(
                solver.subtreeWithAllDeepest(root2).val
        ); // 1

        // Example 3: [0,1,3,null,2]
        TreeNodeSmallestSubtreeWithAllTheDeepestNodes root3 =
                new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(0,
                        new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(1,
                                null,
                                new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(2)
                        ),
                        new TreeNodeSmallestSubtreeWithAllTheDeepestNodes(3)
                );

        System.out.println(
                solver.subtreeWithAllDeepest(root3).val
        ); // 2
    }
}

class TreeNodeSmallestSubtreeWithAllTheDeepestNodes {
    int val;
    TreeNodeSmallestSubtreeWithAllTheDeepestNodes left;
    TreeNodeSmallestSubtreeWithAllTheDeepestNodes right;

    TreeNodeSmallestSubtreeWithAllTheDeepestNodes() {}

    TreeNodeSmallestSubtreeWithAllTheDeepestNodes(int val) {
        this.val = val;
    }

    TreeNodeSmallestSubtreeWithAllTheDeepestNodes(
            int val,
            TreeNodeSmallestSubtreeWithAllTheDeepestNodes left,
            TreeNodeSmallestSubtreeWithAllTheDeepestNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
