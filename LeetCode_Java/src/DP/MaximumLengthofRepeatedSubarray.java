package DP;

/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */
public class MaximumLengthofRepeatedSubarray {
	public int findLength(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;
        int max = 0;
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(dp[i][j], max);
                    }
                }
            }
        }
        return max;
    }
}
