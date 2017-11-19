package String;

/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
public class ReverseString {
	public String reverseString(String s) {
        char[] c = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(s.length() - i - 1);
		}
		return new String (c);
    }
}
