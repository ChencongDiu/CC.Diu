package Array;

/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
	public void sortColors(int[] nums) {
        /*
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i: nums) {
            if (i == 0) {
                num0++;
            } else if (i == 1) {
                num1++;
            } else {
                num2++;
            }
        }
        for (int i = 0; i < num0; i++) {
            nums[i] = 0;
        }
        for (int i = num0; i < num0 + num1; i++) {
            nums[i] = 1;
        }
        for (int i = num0 + num1; i < num0 + num1 + num2; i++) {
            nums[i] = 2;
        }
        */
        int low = 0, high = nums.length - 1;
        for (int i = 0; i <= high; i++) {
            if (nums[i] == 0) {
                int temp = nums[low];
                nums[low++] = nums[i];
                nums[i] = temp;
            } else if (nums[i] == 2) {
                int temp = nums[high];
                nums[high--] = nums[i];
                nums[i--] = temp;
            }
        }
    }
}
