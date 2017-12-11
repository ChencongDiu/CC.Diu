package DP;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */

//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class LongestIncreasingSubsequence {
	/*public int lengthOfLIS(int[] nums) {
        //keep the tails of substrings with various length
        int[] tails = new int[nums.length];
        int res = 0;
        
        for (int num: nums) {
            //for every new number, search and update tails array
            if (res == 0) {
                tails[0] = num;
                res++;
            } else {
                int pos = 0;
                while (pos < res) {
                    if (tails[pos] < num) pos++;
                    else break;
                }
                tails[pos] = num;
                if (pos == res) res++;
            }
        }
        return res;
    }*/
	
	//optimize search part (#1 binary function)
	//https://www.tutorialspoint.com/java/util/arrays_binarysearch_int.htm
	/*public int lengthOfLIS(int[] nums) {
        //keep the tails of substrings with various length
        int[] tails = new int[nums.length];
        int res = 0;
        
        for (int num: nums) {
            //for every new number, search and update tails array
            int i = Arrays.binarySearch(tails, 0, res, num);
            if (i < 0) i = -(i + 1);
            tails[i] = num;
            if (i == res) res++;
        }
        return res;
    }*/
	
	//optimize search part (#2 manually binary)
	public int lengthOfLIS(int[] nums) {
        //keep the tails of substrings with various length
        int[] tails = new int[nums.length];
        int res = 0;
        
        for (int num: nums) {
            //for every new number, search and update tails array
            int l = 0, r = res;
            while (l != r) {
                int m = l - (l - r) / 2;
                if (tails[m] < num) l = m + 1;
                else r = m;
            }
            tails[l] = num;
            if (l == res) res++;
        }
        return res;
    }
}
