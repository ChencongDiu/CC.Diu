package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {
	public String[] findWords(String[] words) {
        Set<Character> S1 = new HashSet<> ();
		Set<Character> S2 = new HashSet<> ();
		Set<Character> S3 = new HashSet<> ();
		char[] R1 = new char[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
		char[] R2 = new char[] {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
		char[] R3 = new char[] {'z', 'x', 'c', 'v', 'b', 'n', 'm'};
		for (char c: R1) S1.add(c);
		for (char c: R2) S2.add(c);
		for (char c: R3) S3.add(c);
		ArrayList<String> result = new ArrayList<String> ();
		for (int i = 0; i < words.length; i++) {
			boolean flag = true;
			String word = words[i].toLowerCase();
			if (S1.contains(word.charAt(0))) {
				for (int j = 0; j < word.length(); j++)
					if (!S1.contains(word.charAt(j))) {
						flag = false;
						break;
					}
			}
			else if (S2.contains(word.charAt(0))) {
				for (int j = 0; j < word.length(); j++)
					if (!S2.contains(word.charAt(j))) {
						flag = false;
						break;
					}
			}
			else if (S3.contains(word.charAt(0))) {
				for (int j = 0; j < word.length(); j++)
					if (!S3.contains(word.charAt(j))) {
						flag = false;
						break;
					}
			}
			if (flag) {
				result.add(words[i]);
				System.out.println(words[i]);
			}
		}
		String[] r = new String[result.size()];
		for (int i = 0; i < result.size(); i++) r[i] = result.get(i);
		return r;
    }
}
