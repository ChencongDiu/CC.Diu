package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<> ();
        dfs(root, res, new ArrayList<Integer> (), sum);
        return res;
    }
    public void dfs(TreeNode root, List<List<Integer>> res, ArrayList<Integer> path, int sum) {
    	if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer> (path));
            path.remove(path.size() - 1);
            return;
        }
        dfs(root.left, res, path, sum - root.val);
        dfs(root.right, res, path, sum - root.val);
        path.remove(path.size() - 1);
    }
}
