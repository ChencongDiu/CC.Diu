package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if (k < 1 || k > 9 || n < 1 || n > 45) return res;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> ele = new ArrayList<Integer> ();
        f(res, ele, nums, k, n, 0);
        return res;
    }
    public void f(List<List<Integer>> res, List<Integer> ele, int[] nums, int k, int n, int start) {
        if (k == 0 && n == 0) res.add(new ArrayList<Integer> (ele));
        for (int i = start; i < nums.length && n > 0 && k > 0; i++) {
            ele.add(nums[i]);
            f(res, ele, nums, k - 1, n - nums[i], i + 1);
            ele.remove(ele.size() - 1);
        }
    }
}
