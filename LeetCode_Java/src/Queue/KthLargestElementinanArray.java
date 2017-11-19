package Queue;

import java.util.PriorityQueue;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
 */
public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> kMax = new PriorityQueue<> ();
        for (int ele: nums) {
            kMax.add(ele);
            if (kMax.size() > k) {
                kMax.poll();
            }
        }
        return kMax.peek();
    }
}
