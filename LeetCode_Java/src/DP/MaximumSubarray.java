package DP;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {return nums[0];}
		int res = nums[0], dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = (dp + nums[i] > nums[i])? dp + nums[i]: nums[i];
            res = Math.max(dp, res);
        }
        return res;
	}
}
