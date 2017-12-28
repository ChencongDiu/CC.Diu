package DP;

/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
	public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        return Math.max(dp(nums, 0, len - 2), dp(nums, 1, len - 1));
    }
    
    public int dp(int[] nums, int l, int r) {
        int preRob = 0, preNotRob = 0;
        for (int i = l; i <= r; i++) {
            int temp = preRob;
            preRob = nums[i] + preNotRob;
            preNotRob = Math.max(preNotRob, temp);
        }
        return Math.max(preRob, preNotRob);
    }
}
