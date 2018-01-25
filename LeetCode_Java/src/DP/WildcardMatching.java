package DP;

/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "*") ¡ú true
isMatch("aa", "a*") ¡ú true
isMatch("ab", "?*") ¡ú true
isMatch("aab", "c*a*b") ¡ú false
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // null match p
        for (int i = 0; i < p.length(); i++) {
            if (dp[0][i] && p.charAt(i) == '*') dp[0][i + 1] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
