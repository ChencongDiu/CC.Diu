package DP;

/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {
	/*int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }*/
	public int countSubstrings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        boolean[][] isPalindromes = new boolean[len][len];
        dp[0] = 1;
        
        for (int i = 0; i < len; i++) {
            isPalindromes[i][i] = true; //single chars are always palindromic
        }
        
        for (int i = 1; i < len; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 > i - 1 || isPalindromes[j + 1][i - 1]) {
                        isPalindromes[j][i] = true;
                        count++;
                    }
                }
                dp[i] = dp[i - 1] + count;
            }
        }
        return dp[len - 1];
    }
}
