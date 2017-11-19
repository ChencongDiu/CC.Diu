package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageofLevelsinBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
        List<List<Double>> list = new ArrayList<> ();
        list = dfs(root, list, 0);
        List<Double> res = new ArrayList<> ();
        for (List<Double> l: list) {
            res.add((l.get(0) / l.get(1)));
        }
        return res;
    }
    public List<List<Double>> dfs(TreeNode root, List<List<Double>> list, int level) {
        if (root == null) {return list;}
        if (list.size() <= level) {
            List<Double> ele = new ArrayList<> ();
            ele.add((root.val)/1.0);
            ele.add(1.0);
            list.add(ele);
        } else {
            double sum = list.get(level).get(0);
            double number = list.get(level).get(1);
            sum += root.val;
            number++;
            list.get(level).set(0, sum);
            list.get(level).set(1, number);
        }
        dfs(root.left, list, level + 1);
        dfs(root.right, list, level + 1);
        return list;
    }
}
