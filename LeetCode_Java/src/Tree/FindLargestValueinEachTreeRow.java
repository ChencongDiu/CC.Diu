package Tree;

import java.util.ArrayList;
import java.util.List;

/*
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
 */
public class FindLargestValueinEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res, int height) {
        if (root == null) return;
        if (res.size() == height) {
            res.add(root.val);
        }
        res.set(height, Math.max(res.get(height), root.val));
        helper(root.left, res, height + 1);
        helper(root.right, res, height + 1);
    }
}
