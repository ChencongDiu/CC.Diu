package HashTable;

import java.util.Arrays;

/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())	return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        for (int i = 0; i < sArr.length; i++) {
        	if (sArr[i] != tArr[i])	return false;
        }
        
        return true;
        
        /*Hashtable<Integer, Character> hs = new Hashtable<> ();
        for (int i = 0; i < s.length(); i++)
        	hs.put(i, s.charAt(i));
        
        for (int j = 0; j < t.length(); j++) {
        	if (hs.contains(t.charAt(j))) {
        		hs.
        		hs.remove(, t.));
        		continue;
        	}
        	return false;
        }*/
    }
}
