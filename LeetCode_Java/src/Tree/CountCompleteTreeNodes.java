package Tree;

/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = getLeftHeight(root);
        int r = getRightHeight(root);
        if (l == r) return (1 << (r + 1)) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int getLeftHeight(TreeNode root) {
        int res = 0;
        while (root.left != null) {
            root = root.left;
            res++;
        }
        return res;
    }
    
    public int getRightHeight(TreeNode root) {
        int res = 0;
        while (root.right != null) {
            root = root.right;
            res++;
        }
        return res;
    }
}
