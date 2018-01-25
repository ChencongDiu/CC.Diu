package Greedy;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
        /*if (nums == null || nums.length == 0) return false;
        for (int i = nums.length - 2; i >= 0; i--) {
            // can move
            if (nums[i] != 0) {
                continue;
            } else {
                // find if we can cross the gap
                boolean found = false;
                int j = i - 1;
                while (j >= 0) {
                    if (nums[j] > i - j) {
                        found = true;
                        break;
                    }
                    j--;
                }
                if (!found) return false;
            }
        }
        return true;*/
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
