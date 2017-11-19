package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
 */
public class IntersectionofTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<> ();
        HashMap<Integer, Integer> hm = new HashMap<> ();
        for (int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i], hm.getOrDefault(nums1[i], 0) + 1);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (hm.containsKey(nums2[j])) {
                if (hm.get(nums2[j]) > 0) {
                    list.add(nums2[j]);
                    hm.put(nums2[j], hm.get(nums2[j]) - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
