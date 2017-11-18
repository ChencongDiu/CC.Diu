package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<> ();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        int len = nums.length;
        
        for (int i1 = 0; i1 < len - 3; i1++) {
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) continue;
            for (int i4 = len - 1; i4 > i1 + 2; i4--) {
                if (i4 < len - 1 && nums[i4] == nums[i4 + 1]) continue;
                int twosum = target - nums[i1] - nums[i4];
                int i2 = i1 + 1, i3 = i4 - 1;
                while (i2 < i3) {
                    if (i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) {
                        i2++;
                        continue;
                    }
                    if (i3 < i4 - 1 && nums[i3] == nums[i3 + 1]) {
                        i3--;
                        continue;
                    }
                    if (nums[i2] + nums[i3] < twosum) {
                        i2++;
                    } else if (nums[i2] + nums[i3] > twosum) {
                        i3--;
                    } else {
                        res.add(new ArrayList<Integer> (Arrays.asList(nums[i1], nums[i2++], nums[i3--], nums[i4])));
                    }
                }
            }
        }
        
        return res;
    }
}
