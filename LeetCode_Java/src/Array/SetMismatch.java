package Array;

import java.util.Arrays;

/*
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
 */
public class SetMismatch {
	public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int rightsum = 0;
        int sum = 0;
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            rightsum += (i + 1);
            sum += nums[i];
            if (nums[i] == nums[i + 1]) res[0] = nums[i];
        }
        rightsum += nums.length;
        sum += nums[nums.length - 1];
        res[1] = res[0] + (rightsum - sum);
        
        return res;
    }
}
