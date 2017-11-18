package Array;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        int length = nums.length;
        double number = Math.pow(2, length);
        for (int i = 0; i < number; i++) {
        	String bit = Integer.toString(i, 2);
        	while (bit.length() != length) bit = "0" + bit;
        	List<Integer> ele = new ArrayList<> ();
        	for (int j = 0; j < length; j++) {
        		if (bit.charAt(j) != '0') ele.add(nums[j]);
        	}
        	res.add(ele);
        }
        
        return res;
    }
}
