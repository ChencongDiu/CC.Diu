package DP;

import java.util.List;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;
            for (String ele: wordDict) {
                int len = ele.length();
                int end = len + i;
                if (end > s.length()) continue;
                if (dp[end]) continue;
                if (s.substring(i, end).equals(ele)) {
                    dp[end] = true;
                }
            }
        }
        return dp[s.length()];
    }
    /* public boolean helper(String s, List<String> wordDict, int start) {
        if (start == s.length()) {return true;}
        for (String ele: wordDict) {
            int eleLength = ele.length();
            if (start + eleLength > s.length()) {continue;}
            if (s.substring(start, start + eleLength).equals(ele)) {
                if (helper(s, wordDict, start + eleLength)) {return true;}
            }
        }
        return false;
    } */
}
