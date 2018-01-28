package Array;

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        int res = 0;
        for (int n: nums) {
            if (res < 2 || n > nums[res - 2]) {
                nums[res] = n;
                res++;
            }
        }
        return res;
    }
}
