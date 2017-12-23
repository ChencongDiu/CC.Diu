package Tree;

/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
 */
public class LongestUnivaluePath {
	int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }
    
    public int dfs(TreeNode root) {
        int l = root.left != null? dfs(root.left): 0;
        int r = root.right != null? dfs(root.right): 0;
        int cl = root.left != null && root.left.val == root.val? l + 1: 0;
        int cr = root.right != null && root.right.val == root.val? r + 1: 0;
        res = Math.max(res, cl + cr);
        return Math.max(cl, cr);
    }
}
