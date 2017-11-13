package Array;

/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */

//put valid number into their position
//e.g. [3,4,-1,1] -> [1,-1,3,4]
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        int len = nums.length;
		for (int i = 0; i < len; i++) {
			int val = nums[i];
			if (val == i + 1 || val <= 0 || val > len) continue;
			//take val as another index
			int newVal = nums[val - 1];
			if (newVal == val) continue;
			//swap without endless loop
			swap(nums, i, val - 1);
			i--;
		}
		int i = 0;
        while (i < len && i + 1 == nums[i]) i++;
        return i + 1;
    }
    public void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
}
