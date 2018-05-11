package Stack;

import java.util.Stack;

/*
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
	public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<> ();
        Stack<String> segStack = new Stack<> ();
        
        int idx = 0;
        while (idx < s.length()) {
            // is number
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx++) - '0');
                }
                countStack.push(count);
            }
            // is '[', start of a new segment
            else if (s.charAt(idx) == '[') {
                segStack.push(res);
                res = "";
                idx++;
            }
            // is letter
            else if (s.charAt(idx) != ']') {
                res += s.charAt(idx++);
            }
            // is ']', end of a segment
            else {
                StringBuilder sb = new StringBuilder(segStack.pop());
                int t = countStack.pop();
                for (int i = 0; i < t; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            }
        }
        return res;
    }
}
