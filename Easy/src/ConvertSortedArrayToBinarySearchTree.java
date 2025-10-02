import java.util.*;

public class ConvertSortedArrayToBinarySearchTree {
    // Hàm chính
    public TreeNodeConvertSortedArrayToBinarySearchTree sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNodeConvertSortedArrayToBinarySearchTree build(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNodeConvertSortedArrayToBinarySearchTree root =
                new TreeNodeConvertSortedArrayToBinarySearchTree(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }

    // In-order traversal để kiểm tra BST
    public void inorder(TreeNodeConvertSortedArrayToBinarySearchTree root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree solver = new ConvertSortedArrayToBinarySearchTree();

        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNodeConvertSortedArrayToBinarySearchTree root1 = solver.sortedArrayToBST(nums1);
        System.out.print("Inorder of BST 1: ");
        solver.inorder(root1); // -10 -3 0 5 9
        System.out.println();

        int[] nums2 = {1, 3};
        TreeNodeConvertSortedArrayToBinarySearchTree root2 = solver.sortedArrayToBST(nums2);
        System.out.print("Inorder of BST 2: ");
        solver.inorder(root2); // 1 3
        System.out.println();
    }
}

// TreeNode riêng cho bài này
class TreeNodeConvertSortedArrayToBinarySearchTree {
    int val;
    TreeNodeConvertSortedArrayToBinarySearchTree left;
    TreeNodeConvertSortedArrayToBinarySearchTree right;
    TreeNodeConvertSortedArrayToBinarySearchTree() {}
    TreeNodeConvertSortedArrayToBinarySearchTree(int val) { this.val = val; }
    TreeNodeConvertSortedArrayToBinarySearchTree(int val,
                                                 TreeNodeConvertSortedArrayToBinarySearchTree left,
                                                 TreeNodeConvertSortedArrayToBinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
