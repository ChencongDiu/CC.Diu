package Tree;

import java.util.HashSet;

/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */
public class TwoSumIV_InputisaBST {
	public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<> ();
        return dfs(root, hs, k);
    }
    public boolean dfs(TreeNode root, HashSet<Integer> hs, int k) {
        if (root == null) {return false;}
        if (hs.contains(k - root.val)) {return true;}
        else {hs.add(root.val);}
        return (dfs(root.left, hs, k) || dfs(root.right, hs, k));
    }
}
