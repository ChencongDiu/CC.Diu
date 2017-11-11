package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations {
	private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<> ();
        backtracking(nums, new ArrayList<> ());
        return res;
    }
    public void backtracking(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<> (list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                backtracking(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
