package Array;

/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */

//just like find circle in linkedlist
public class FindtheDuplicateNumber {
	/* array is modified
    public int findDuplicate(int[] nums) {
        int res = -1;
        if (nums.length < 2) return res;
        
        for (int i = 0; i < nums.length; i++) {
            int newpos = Math.abs(nums[i]);
            if (nums[newpos] < 0) return newpos;
            nums[newpos] *= -1;
        }
        
        return res;
    }
    */
    public int findDuplicate(int[] nums) {
        int res = -1;
        if (nums.length < 2) return res;
        int walker = nums[0], runner = nums[nums[0]];
        while (walker != runner) {
        	walker = nums[walker];
        	runner = nums[nums[runner]];
        }
        runner = 0;
        while (walker != runner) {
        	walker = nums[walker];
        	runner = nums[runner];
        }
        return walker;
    }
}
