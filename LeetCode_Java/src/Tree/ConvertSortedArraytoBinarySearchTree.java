package Tree;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode head = BSTBuilder(nums, 0, nums.length - 1);
        return head;
    }
    
    public TreeNode BSTBuilder(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = end - (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = BSTBuilder(nums, start, mid - 1);
        node.right = BSTBuilder(nums, mid + 1, end);
        return node;
    }
}
