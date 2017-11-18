package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<> ();
        int level = 0;
        helper(res, root, level);
        return res;
    }
    public void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() <= level) {
            List<Integer> ele = new ArrayList<> ();
            ele.add(root.val);
            res.add(ele);
        } else {
            res.get(level).add(root.val);
        }
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
