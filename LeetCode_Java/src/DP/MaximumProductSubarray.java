package DP;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

//max[0, i] is decided by min[0, i - 1], max[0, i - 1] and nums[i].
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = min;
            min = Math.min(Math.min(min * nums[i], max * nums[i]), nums[i]);
            max = Math.max(Math.max(temp * nums[i], max * nums[i]), nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
