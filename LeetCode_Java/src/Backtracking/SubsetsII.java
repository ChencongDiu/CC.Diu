package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<> ();
        
        for (int i = 0; i <= nums.length; i++) {
            backtracking(res, new ArrayList<Integer> (), 0, i, nums);
        }
        return res;
    }
    
    public void backtracking(List<List<Integer>> res, ArrayList<Integer> curList, int startPos, int count, int[] nums) {
        if (count == 0) {
            res.add(new ArrayList<Integer> (curList));
            return;
        }
        for (int i = startPos; i < nums.length; i++) {
            if (i != startPos && nums[i] == nums[i - 1]) continue;
            curList.add(nums[i]);
            backtracking(res, curList, i + 1, count - 1, nums);
            curList.remove(curList.size() - 1);
        }
    }
}
