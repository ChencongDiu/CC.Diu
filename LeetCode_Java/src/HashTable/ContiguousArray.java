package HashTable;

import java.util.HashMap;

/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {
	public int findMaxLength(int[] nums) {
        int sum = 0;
        int res = 0;
        int len = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<> ();
        hm.put(sum, -1);
        for (int i = 0; i < len; i++) {
            nums[i] = (nums[i] == 0? -1: 1);
            sum += nums[i];
            if (hm.containsKey(sum)) res = Math.max(res, i - hm.get(sum));
            hm.put(sum, hm.getOrDefault(sum, i));
        }
        return res;
    }
}
