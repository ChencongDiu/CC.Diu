package String;

import java.util.HashMap;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
	    if (s.length() == 0) 
	    		return 0;
	    	int result = 0;
	    	HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
	    	
	    	for (int i = 0, j = 0; j < s.length(); j++) {
	    		//move left point if duplicate char is found, make sure [i, j] contains no duplication
	    		if (map.containsKey(s.charAt(j))) {
	    			i = Math.max(i, map.get(s.charAt(j)) + 1);
	    		}
	    		map.put(s.charAt(j), j);
	    		result = Math.max(result, j - i + 1);
	    	}
	    	
		return result;
	    }
}
