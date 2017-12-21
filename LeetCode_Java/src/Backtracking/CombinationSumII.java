package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
                if (i != startPos && dict[i] == dict[i - 1]) continue; //prevent duplications
                curList.add(dict[i]);
                backtracking(res, curList, dict, i + 1, sum + dict[i], target);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
