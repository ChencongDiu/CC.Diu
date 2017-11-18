package Array;

import java.util.Arrays;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than Math.floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    /*public int majorityElement(int[] nums) {
        int count = 0;
        int majority = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i]; //if count == 0, then the subset have already traversed has no majority, so if the subset including current element has majority, current element must be majority
                count++;
            } else if (majority == nums[i]) {
                count++; 
            } else {
                count--;
            }
        }
        return majority;
	}*/
	public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
