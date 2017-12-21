package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<> ();
        backtracking(res, new ArrayList<Integer> (), 1, n, k);
        return res;
    }
    public void backtracking(List<List<Integer>> res, ArrayList<Integer> curList, int startN, int maxN, int count) {
        if (count == 0) {
            res.add(new ArrayList<Integer> (curList));
            return;
        }
        for (int i = startN; i <= maxN; i++) {
            curList.add(i);
            backtracking(res, curList, i + 1, maxN, count - 1);
            curList.remove(curList.size() - 1);
        }
    }
}
