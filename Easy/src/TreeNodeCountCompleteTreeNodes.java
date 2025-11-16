import java.util.*;

class CountCompleteTreeNodes {
    public int countNodes(TreeNodeCountCompleteTreeNodes root) {
        if (root == null) return 0;

        int left = leftHeight(root);
        int right = rightHeight(root);

        // Nếu cây full → số node = 2^h - 1
        if (left == right) {
            return (1 << left) - 1;
        }

        // Nếu không full → đếm đệ quy hai nhánh
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNodeCountCompleteTreeNodes node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }

    private int rightHeight(TreeNodeCountCompleteTreeNodes node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.right;
        }
        return h;
    }

    // ---------- MAIN TEST ----------
    public static void main(String[] args) {
        CountCompleteTreeNodes solver = new CountCompleteTreeNodes();

        // Test 1: [1,2,3,4,5,6] -> 6
        TreeNodeCountCompleteTreeNodes root1 = new TreeNodeCountCompleteTreeNodes(1,
                new TreeNodeCountCompleteTreeNodes(2, new TreeNodeCountCompleteTreeNodes(4), new TreeNodeCountCompleteTreeNodes(5)),
                new TreeNodeCountCompleteTreeNodes(3, new TreeNodeCountCompleteTreeNodes(6), null)
        );
        System.out.println(solver.countNodes(root1)); // 6

        // Test 2: []
        System.out.println(solver.countNodes(null)); // 0

        // Test 3: [1]
        TreeNodeCountCompleteTreeNodes root3 = new TreeNodeCountCompleteTreeNodes(1);
        System.out.println(solver.countNodes(root3)); // 1
    }
}

// TreeNode riêng cho bài này
class TreeNodeCountCompleteTreeNodes {
    int val;
    TreeNodeCountCompleteTreeNodes left;
    TreeNodeCountCompleteTreeNodes right;

    TreeNodeCountCompleteTreeNodes() {}
    TreeNodeCountCompleteTreeNodes(int val) { this.val = val; }
    TreeNodeCountCompleteTreeNodes(int val, TreeNodeCountCompleteTreeNodes left, TreeNodeCountCompleteTreeNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
