package String;

/*
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }
    
    //return length of the longest substring of s from start to end such that every character in substring appears no less than k times
    public int helper(String s, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }
        
        //first, get frequencies
        int[] f = new int[26];
        for (int i = start; i < end; i++) {
            f[s.charAt(i) - 'a']++;
        }
        
        //check whether valid
        for (int i = 0; i < 26; i++) {
            //valid, cut the substring into two, recurse
            if (f[i] > 0 && f[i] < k) {
                for (int j = start; j < end; j++) {
                    if (s.charAt(j) == i + 'a') {
                        int left = helper(s, start, j, k);
                        int right = helper(s, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}
