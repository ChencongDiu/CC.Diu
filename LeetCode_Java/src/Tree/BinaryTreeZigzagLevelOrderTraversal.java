package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	private List<List<Integer>> res;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<> ();
        bfs(root, 0);
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
    public void bfs(TreeNode root, int level) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(new ArrayList<Integer> ());
        }
        res.get(level).add(root.val);
        
        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
    }
}
