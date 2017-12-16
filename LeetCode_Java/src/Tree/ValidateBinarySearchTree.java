package Tree;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, Long.MIN_VALUE, root.val) && helper(root.right, root.val, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (low < root.val && root.val < high) {
            return helper(root.left, low, root.val) && helper(root.right, root.val, high);
        }
        return false;
    }
}
