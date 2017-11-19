package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
        List<Integer>[] bs = new ArrayList[nums.length + 1];
        List<Integer> res = new ArrayList<Integer> ();
        for (int i: nums) hm.put(i, hm.getOrDefault(i, 0) + 1);
        for (int key: hm.keySet()) {
            int frequency = hm.get(key);
            if (bs[frequency] == null) {
                bs[frequency] = new ArrayList<> ();
            }
            bs[frequency].add(key);
        }
        for (int i = bs.length - 1; i >= 0 && res.size() < k; i--) {
            if (bs[i] != null) {
                res.addAll(bs[i]);
            }
        }
        return res;
    }
}
