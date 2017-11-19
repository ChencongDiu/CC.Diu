package HashTable;

import java.util.HashMap;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
        if (s.length() < 2) return true;
		HashMap<Character, Character> map = new HashMap<> ();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (!map.containsKey(a)) {
				if (map.containsValue(b)) return false;
				map.put(a, b);
			} else {
				if (map.get(a) == b) continue;
				return false;
			}
		}
		return true;
    }
}
