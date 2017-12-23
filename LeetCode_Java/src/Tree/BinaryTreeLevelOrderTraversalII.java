package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<> ();
        bfs(root, res, 0);
        return res;
    }
    
	//bfs
	public void bfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level == res.size()) res.add(0, new ArrayList<Integer> ());
        bfs(root.left, res, level + 1);
        bfs(root.right, res, level + 1);
        res.get(res.size() - level - 1).add(root.val);
    }
}
