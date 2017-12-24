package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).


 */
public class FindModeinBinarySearchTree {
	Integer pre = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<> ();
        helper(root, res);
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) r[i] = res.get(i);
        return r;
    }
    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        if (pre != null) {
            if (root.val == pre) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            res.clear();
            res.add(root.val);
        } else if (count == max) {
            res.add(root.val);
        }
        pre = root.val;
        helper(root.right, res);
    }
}
