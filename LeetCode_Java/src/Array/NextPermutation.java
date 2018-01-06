package Array;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        int len = nums.length, p = -1, pv = 0;
        //search the first descending
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                p = i;
                pv = nums[i];
                break;
            }
        }
        if (p == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        for (int i = len - 1; i > p; i--) {
            if (nums[i] > pv) {
                swap(nums, p, i);
                break;
            }
        }
        //sort [p + 1, len - 1]
        reverse(nums, p + 1, len - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    public void swap(int[] nums, int pos1, int pos2) {
        nums[pos1] ^= nums[pos2];
        nums[pos2] ^= nums[pos1];
        nums[pos1] ^= nums[pos2];
    }
}
