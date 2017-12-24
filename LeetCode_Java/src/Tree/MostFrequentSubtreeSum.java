package Tree;

import java.util.HashMap;

/*
Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {
	int max = 0;
    int count = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap<> ();
        post(hm, root);
        int[] res = new int[count];
        int i = 0;
        for (int n: hm.keySet()) {
            if (hm.get(n) == max) {
                res[i++] = n;
            }
        }
        return res;
    }
    
    public int post(HashMap<Integer, Integer> hm, TreeNode root) {
        if (root == null) return 0;
        int subSum = root.val + post(hm, root.left) + post(hm, root.right);
        hm.put(subSum, hm.getOrDefault(subSum, 0) + 1);
        if (hm.get(subSum) > max) {
            max = hm.get(subSum);
            count = 1;
        } else if (hm.get(subSum) == max) {
            count++;
        }
        return subSum;
    }
}
