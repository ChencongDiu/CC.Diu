package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return builder(1, n);
    }
    
    public List<TreeNode> builder(int start, int end) {
        List<TreeNode> res = new ArrayList<> ();
        
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        
        List<TreeNode> left;
        List<TreeNode> right;
        for (int i = start; i <= end; i++) {
            left = builder(start, i - 1);
            right = builder(i + 1, end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}
