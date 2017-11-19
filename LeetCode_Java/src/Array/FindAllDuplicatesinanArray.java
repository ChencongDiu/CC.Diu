package Array;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers, 1 ¡Ü a[i] ¡Ü n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

 */
public class FindAllDuplicatesinanArray {
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<> ();
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]);
            int k = nums[j - 1];
            if (k < 0) result.add(j);
            else nums[j - 1] *= -1;
        }
        return result;
    }
}
