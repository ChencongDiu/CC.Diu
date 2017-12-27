package Backtracking;

/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 */
public class PartitiontoKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] used = new int[nums.length];
        return backtracking(nums, used, k, target, 0, 0);
    }
    
    public boolean backtracking(int[] nums, int[] used, int count, int target, int startPos, int curSum) {
        if (count == 0) return true;
        if (curSum == target) return backtracking(nums, used, count - 1, target, 0, 0);
        for (int i = startPos; i < nums.length; i++) {
            if (used[i] == 1 || curSum + nums[i] > target) continue;
            used[i] = 1;
            if (backtracking(nums, used, count, target, i + 1, curSum + nums[i])) return true;
            used[i] = 0;
        }
        return false;
    }
}
