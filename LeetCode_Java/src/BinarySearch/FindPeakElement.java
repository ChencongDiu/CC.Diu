package BinarySearch;

/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -¡Ş.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
	/*
    public int findPeakElement(int[] nums) {
        if (nums.length != 1) {
            for (int i = 0; i < nums.length; i++) {
                //first element
                if (i == 0) {
                    if (nums[i] > nums[i + 1]) return i;
                } else if (i == nums.length - 1) {
                    if (nums[i] > nums[i - 1]) return i;
                } else {
                    if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1] ) return i;
                }
            }
        }
        return 0;
    }
    */
    
    //binary search, "return the index to any one of the peaks is fine"
    public int findPeakElement(int[] nums) {
        return bisearch(nums, 0, nums.length - 1);
    }
    public int bisearch(int[] nums, int start, int end) {
        if (start == end) return start;
        if (start + 1 == end) return (nums[start] > nums[end])? start: end;
        
        int mid = start + (end - start) / 2;
        if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
        else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) return bisearch(nums, mid + 1, end);
        else return bisearch(nums, start, mid - 1);
    }
}
