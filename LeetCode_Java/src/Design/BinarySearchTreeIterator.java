package Design;

import java.util.Stack;

/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator {
	private Stack<TreeNode> stackTree = new Stack<TreeNode> ();
    
    public BinarySearchTreeIterator(TreeNode root) {
        while (root != null) {
            stackTree.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stackTree.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stackTree.pop();
        TreeNode root = res.right;
        while (root != null) {
            stackTree.push(root);
            root = root.left;
        }
        return res.val;
    }
}
