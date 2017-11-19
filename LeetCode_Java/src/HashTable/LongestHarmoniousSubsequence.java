package HashTable;

import java.util.HashMap;

/*
We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
        for (int i: nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (int n: hm.keySet()) {
            if (hm.containsKey(n + 1)) {
                res = Math.max(res, hm.get(n) + hm.get(n + 1));
            }
        }
        return res;
    }
}
