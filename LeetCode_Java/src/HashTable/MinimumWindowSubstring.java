package HashTable;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        int[] dict = new int[128];
        int left = 0, right = 0, res = Integer.MAX_VALUE, startIndex = 0, counter = t.length();
        for (int i = 0; i < t.length(); i++) dict[t.charAt(i)]++;
        
        while (right < s.length()) {
            char r = s.charAt(right);
            if (dict[r] > 0) counter--; //-- only dict[r] > 0
            dict[r]--;
            right++;
            while (counter == 0) {
                if (right - left < res) {
                    res = right - left;
                    startIndex = left;
                }
                char l = s.charAt(left);
                dict[l]++;
                if (dict[l] > 0) counter++; // ++ only dict[l] > 0
                left++;
            }
        }
        
        return res == Integer.MAX_VALUE? "": s.substring(startIndex, startIndex + res);
    }
}
