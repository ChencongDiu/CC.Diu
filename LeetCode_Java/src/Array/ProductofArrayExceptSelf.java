package Array;

/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res  = new int[length];
        
        int left   = 1;
        for (int i = 0; i < length; i++) {
            if (i > 0) left *= nums[i - 1];
            res[i] = left;
        }
        
        int right  = 1;
        for (int j = length - 1; j > -1; j--) {
            if (j < length - 1) right *= nums[j + 1];
            res[j] *= right;
        }
        
        return res;
    }
}
