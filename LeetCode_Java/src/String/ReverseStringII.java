package String;

/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

 */
public class ReverseStringII {
	public String reverseStr(String s, int k) {
        int start = 0;
       int end = 0;
       char[] sArr = s.toCharArray();
		while (start < s.length() - 1) {
			end = (start + k - 1 <= s.length() - 1)? start + k - 1: s.length() - 1;
			sArr = charSwitch(sArr, start, end);
			start += 2 * k;
		}
		return new String(sArr);
   }
   public char[] charSwitch(char[] sArr, int start, int end) {
       while (start < end) {
           char temp = sArr[start];
           sArr[start++] = sArr[end];
           sArr[end--] = temp;
       }
       return sArr;
	}
}
