package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].
 */
public class BinaryTreePreorderTraversal {
	//recursive
	/*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        bfs(root, res);
        return res;
    }
    
    public void bfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        bfs(root.left, res);
        bfs(root.right, res);
    }*/
	
	//iterative
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return res;
    }
}
