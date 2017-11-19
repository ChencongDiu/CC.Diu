package String;

/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
        int res = 0;
        int[] alpha = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) alpha[c - 'a']++;
            else alpha[s.charAt(i) - 'A' + 26]++;
        }
        for (int i = 0; i < alpha.length; i++) {
            res += (alpha[i] / 2) * 2;
        }
        return (res == s.length())? res: res + 1;
    }
}
