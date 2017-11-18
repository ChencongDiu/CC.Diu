package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer> ();
        dfs(res, root, 1);
        return res;
    }
    
    public void dfs(List<Integer> res, TreeNode root, int level) {
        if (root == null) return;
        if (level > res.size()) {
            res.add(root.val);
        }
        dfs(res, root.right, level + 1);
        dfs(res, root.left, level + 1);
    }
}
