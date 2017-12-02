package Tree;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementinaBST {
	//most straight, tranditional inorder recursive
	/*private List<Integer> l;
    public int kthSmallest(TreeNode root, int k) {
        l = new ArrayList<> ();
        inorder(root);
        return l.get(k - 1);
    }
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }*/
	
	//binary search
	public int kthSmallest(TreeNode root, int k) {
        int count = countNode(root.left);
        if (k == count + 1) return root.val;
        else if (k < count + 1) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - count - 1);
    }
    public int countNode(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
