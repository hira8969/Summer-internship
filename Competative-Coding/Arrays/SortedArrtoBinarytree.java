package Arrays;


    
import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SortedArrtoBinarytree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);

        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    // Preorder Traversal
    private static void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        preorder(root.left);

        preorder(root.right);
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        System.out.println("Preorder Traversal:");

        preorder(root);
    }
}
