package Tree;

/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
        helper(root);
    }
    
    public TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode leftTail = helper(root.left); //most left of left subtree
        TreeNode rightTail = helper(root.right); //most right of right subtree
        if (leftTail != null) {
            //root.left != null
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            leftTail.right = temp;
        }
        if (rightTail != null) return rightTail; //has right subtree
        if (leftTail != null) return leftTail; //has left subtree
        return root; //root == leaf
    }
}
