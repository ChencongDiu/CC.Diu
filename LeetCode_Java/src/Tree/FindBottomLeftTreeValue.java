package Tree;

/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
 */
public class FindBottomLeftTreeValue {
	//bfs
	private int res = 0, maxHeight = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        bfs(root, 0);
        return res;
    }
    public void bfs(TreeNode root, int level) {
        if (root == null) return;
        if (level > maxHeight) {
            maxHeight = level;
            res = root.val;
        }
        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
    }
}
