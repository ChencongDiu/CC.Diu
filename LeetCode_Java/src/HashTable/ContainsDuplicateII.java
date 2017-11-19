package HashTable;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> ht = new HashMap<> ();
		for (int i = 0; i < nums.length; i++) {
        	if (ht.containsKey(nums[i]) && (i - ht.get(nums[i])) <= k && (i - ht.get(nums[i])) != 0)
        		return true;
        	ht.put(nums[i], i);
        }
        return false;
    }
}
