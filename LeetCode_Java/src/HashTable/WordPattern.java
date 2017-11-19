package HashTable;

import java.util.HashMap;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
		HashMap<Character, String> h = new HashMap<> ();
		
		if (pattern.length() != strArr.length) return false;
		for (int i = 0; i < pattern.length(); i++) {
			char key = pattern.charAt(i);
			String val = strArr[i];
			if (h.containsKey(key)) {
				if (!h.get(key).equals(val))
					return false;
			} else {
				if (h.containsValue(val))
					return false;
				h.put(key, val);
			}
			
		}
		return true;
    }
}
