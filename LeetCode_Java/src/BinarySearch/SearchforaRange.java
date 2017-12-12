package BinarySearch;

/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int l = 0, r = nums.length - 1;
        //binary search: left boundary
        while (l < r) {
            int mid = (l + r) / 2; //natrually biased to left
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[l] != target) return res;
        res[0] = l;
        
        //binary search: right boundary
        r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2 + 1; //forced biased to right
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        res[1] = r;
        return res;
    }
}
