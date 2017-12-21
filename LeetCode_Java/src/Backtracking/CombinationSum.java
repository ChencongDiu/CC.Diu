package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<> ();
        backtracking(res, new ArrayList<Integer> (), candidates, 0, 0, target);
        return res;
    }
    
    public void backtracking(List<List<Integer>> res, ArrayList<Integer> curList, int[] dict, int startPos, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<Integer> (curList));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = startPos; i < dict.length; i++) {
                curList.add(dict[i]);
                backtracking(res, curList, dict, i, sum + dict[i], target);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
