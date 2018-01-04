package Array;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        int res = 0, sum = 0;
        if (nums == null || nums.length < 3) return res;
        int len = nums.length;
        //i, j, l indicate indexes of 3 numbers
        Arrays.sort(nums);
        res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) k--;
                else if (sum < target) j++;
                else return sum;
            }
        }
        return res;
    }
}
