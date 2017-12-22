package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        Arrays.sort(nums);
        backtracking(res, new ArrayList<Integer> (), new int[nums.length], nums);
        return res;
    }
    public void backtracking(List<List<Integer>> res, ArrayList<Integer> curList, int[] used, int[] nums) {
        if (curList.size() == used.length) {
            res.add(new ArrayList<Integer> (curList));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] != 0) continue;
            //these two ways both work, while the procedures of skipping consecutive identical numbers are different:
            //first method will count the consecutive identical numbers when they appear at first time, 'continue' will only be executed
            //when previous identical number is used (from left to right, then count it)
            //second method is completely opposite, 'continue' will be executed when previous identical number is not used
            //(from right to left, then count it)
            //However, the key point of both methods is same, count the consecutive identical sequence only once
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] != 1) continue;
            //if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 1) continue;
            used[i] = 1;
            curList.add(nums[i]);
            backtracking(res, curList, used, nums);
            used[i] = 0;
            curList.remove(curList.size() - 1);
        }
        return;
    }
}
