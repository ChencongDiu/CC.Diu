package BinarySearch;

/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
 */
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] > nums[mid]) {
                //right side is sorted
                if (target < nums[mid] || target > nums[right]) {
                    //not in the right side
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] < nums[mid]) {
                //left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    //in the left side
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //which side is sorted is unknown
                //only know that nums[left] == nums[mid] != target
                if (nums[mid] != nums[right]) {
                    left = mid + 1; //must be in right side
                } else {
                    //nums[left] == nums[mid] == nums[right] != target
                    boolean found = false;
                    for (int step = 1; mid - step >= left && mid + step <= right; step++) {
                        if (nums[mid] != nums[mid - step]) {
                            right = mid - step;
                            found = true;
                        } else if (nums[mid] != nums[mid + step]) {
                            left = mid + step;
                            found = true;
                        }
                    }
                    if (!found) return false;
                }
            }
        }
        return false;
    }
}
