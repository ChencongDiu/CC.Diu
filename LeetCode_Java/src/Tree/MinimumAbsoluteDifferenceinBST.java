package Tree;

import java.util.PriorityQueue;

/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceinBST {
	public int getMinimumDifference(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> ();
        dfs(root, pq);
        int res = Integer.MAX_VALUE;
        int i1 = pq.poll();
        while (!pq.isEmpty()) {
            int i2 = pq.poll();
            res = Math.min(Math.abs(i1 - i2), res);
            i1 = i2;
        }
        return res;
    }
    
    public void dfs(TreeNode root, PriorityQueue<Integer> pq) {
        if(root == null) return;
        pq.offer(root.val);
        dfs(root.left, pq);
        dfs(root.right, pq);
    }
}
