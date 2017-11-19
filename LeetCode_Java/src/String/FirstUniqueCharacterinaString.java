package String;

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */
public class FirstUniqueCharacterinaString {
	public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
        	alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
        	if (alphabet[s.charAt(i) - 'a'] == 1)
        		return i;
        return -1;
    }
}
