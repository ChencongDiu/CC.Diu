package HashTable;

import java.util.HashSet;
import java.util.Set;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */
public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<> ();
		Set<Integer> intersection = new HashSet<> ();
        for (int i = 0; i < nums1.length; i++) 
        	s1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) {
        	if (s1.contains(nums2[i]))
        		intersection.add(nums2[i]);
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int a: intersection)
        	result[i++] = a;
        return result;
    }
}
