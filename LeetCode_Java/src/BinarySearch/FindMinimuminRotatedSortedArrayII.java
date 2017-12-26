package BinarySearch;

/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                //in (mid, right]
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                //in [left, mid]
                right = mid;
            } else {
                //in left or right is unknown
                right--;
            }
        }
        return nums[left];
    }
}
