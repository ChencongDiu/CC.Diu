package Array;

import java.util.HashSet;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> hs = new HashSet<> ();
        for (int i: nums) {hs.add(i);}
        for (int ele: hs) {
            int count = 1;
            if (!hs.contains(ele - 1)) {
                while (hs.contains(++ele)) {
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
