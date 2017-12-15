package Tree;

import java.util.HashMap;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inPosDict = new HashMap<> ();
        for (int i = 0; i < inorder.length; i++) inPosDict.put(inorder[i], i);
        return helper(0, 0, inorder.length - 1, inPosDict, preorder, inorder);
    }
    
    public TreeNode helper(int prePos, int inStart, int inEnd, HashMap<Integer, Integer> inPosDict, int[] preorder, int[] inorder) {
        if (prePos == preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[prePos]);
        int inPos = inPosDict.get(preorder[prePos]);
        root.left = helper(prePos + 1, inStart, inPos - 1, inPosDict, preorder, inorder);
        root.right = helper(prePos + (inPos - inStart) + 1, inPos + 1, inEnd, inPosDict, preorder, inorder);
        return root;
    }
}
