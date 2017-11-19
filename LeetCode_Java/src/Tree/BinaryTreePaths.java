package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
	private List<String> res;
    
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<String> ();
        if (root != null) dfs(root, "");
        return res;
    }
    
    public void dfs(TreeNode root, String path) {
        path += root.val;
        if (root.left == null && root.right == null) res.add(path);
        if (root.left != null) dfs(root.left, path + "->");
        if (root.right != null) dfs(root.right, path + "->");
    }
}
