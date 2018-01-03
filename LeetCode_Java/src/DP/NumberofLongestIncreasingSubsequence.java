package DP;

/*
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class NumberofLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
        int l = nums.length, maxL = 0, res = 0;
        int[] len = new int[l];
        int[] cnt = new int[l];
        for (int i = 0; i < l; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    } else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (maxL == len[i]) res+= cnt[i];
            if (maxL < len[i]) {
                maxL = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
