package Greedy;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 */

// The main idea is based on greedy.
// Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
// Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps.
public class JumpGameII {
	public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curFarest = 0, curEnd = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarest = Math.max(curFarest, i + nums[i]);
            if (curFarest >= nums.length - 1) {
                step++;
                break;
            } else if (i == curEnd) {
                step++;
                curEnd = curFarest;
            }
        }
        return step;
    }
}
