package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */
public class SubtreeofAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode> ();
        q.offer(s);
        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();
            if (isSame(curNode, t)) return true;
            if (curNode.left != null) q.offer(curNode.left);
            if (curNode.right != null) q.offer(curNode.right);
        }
        return false;
    }
    public boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a ==null || b == null) return false;
        if (a.val != b.val) return false;
        return (isSame(a.left, b.left) && isSame(a.right, b.right));
    }
}
