package Tree;

import java.util.HashMap;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<> ();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return treeBuilder(inorder, postorder, inMap, postorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode treeBuilder(int[] inorder, int[] postorder, HashMap<Integer, Integer> inMap, int postPos, int inStart, int inEnd) {
        // Exceptation cases
        if (postPos < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postPos]);
        int inPos = inMap.get(postorder[postPos]);
        root.left = treeBuilder(inorder, postorder, inMap, postPos - (inEnd - inPos) - 1, inStart, inPos - 1);
        root.right = treeBuilder(inorder, postorder, inMap, postPos - 1, inPos + 1, inEnd);
        return root;
    }
}
