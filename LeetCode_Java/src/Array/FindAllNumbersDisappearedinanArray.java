package Array;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers where 1 ¡Ü a[i] ¡Ü n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */
public class FindAllNumbersDisappearedinanArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer> ();
        for (int i = 0; i < nums.length; i++) {
        	int index = nums[i];
        	if (nums[Math.abs(index) - 1] > 0) {
        		nums[Math.abs(index) - 1] = -nums[Math.abs(index) - 1];
        	}
        }
        for (int j = 0; j < nums.length; j++) {
        	if (nums[j] > 0) {
        		result.add(j + 1);
        	}
        }
        return result;
    }
}
