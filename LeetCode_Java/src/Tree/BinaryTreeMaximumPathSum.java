package Tree;

/**
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 * @author x
 *
 */
public class BinaryTreeMaximumPathSum {
	int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxDown(root);
        return res;
    }
    
    // return max sum from root
    private int maxDown(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(maxDown(root.left), 0);
        int r = Math.max(maxDown(root.right), 0);
        res = Math.max(res, l + r + root.val);
        return Math.max(l, r) + root.val;
    }
}
