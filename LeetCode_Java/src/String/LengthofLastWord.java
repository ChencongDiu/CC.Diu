package String;

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
        /*int l = 0;
		s= s.trim();
		for (int i = s.length() - 1; i > -1; i--) {
			if (s.charAt(i) != ' ') {
				l++;
				continue;
			}
			break;
		}
		return l;*/
		s = s.trim();
		return s.length() - s.lastIndexOf(" ") - 1;
    }
}
