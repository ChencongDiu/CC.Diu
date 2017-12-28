package DP;

/*
In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:
The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.
Example 1:
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are ¡°10,¡±0001¡±,¡±1¡±,¡±0¡±
Example 2:
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class OnesandZeroes {
	public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l + 1][m + 1][n + 1]; //max number using m 0's and n 1's from first l strings
        for (int i = 0; i <= l; i++) {
            int[] nums = new int[] {0, 0};
            if (i != 0) {
                nums = helper(strs[i - 1], nums);
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                    } else if (j >= nums[0] && k >= nums[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[l][m][n];
    }
    
    public int[] helper(String s, int[] nums) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                nums[0]++;
            } else {
                nums[1]++;
            }
        }
        return nums;
    }
}
