package Tree;

/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
	//traverse by levels
    public void connect(TreeLinkNode root) {
        TreeLinkNode leader = null; //leader of next level
        TreeLinkNode pre = null; //previous node of next level
        TreeLinkNode cur = root; //current node
        // level by level
        while (cur != null) {
            // node by node
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else {
                        leader = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else {
                        leader = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = leader;
            leader = null;
            pre = null;
        }
    }
}
