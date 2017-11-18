package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
		Arrays.sort(nums);
		
		//skip all same i
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					List<Integer> element = new ArrayList<Integer> ();
					element.add(nums[i]);
					element.add(nums[j]);
					element.add(nums[k]);
					result.add(element);
					j++;
					k--;
					
					while (j < k && nums[j] == nums[j - 1]) j++;
					while (j < k && nums[k] == nums[k + 1]) k--;
				} else if (nums[i] + nums[j] + nums[k] > 0)
					k--;
				else
					j++;
			}
		}
		
		return result;
    }
}
