package String;

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
 */
public class ReverseWordsinaString {
	public static String reverseWords(String s) {
		String[] sArr = s.trim().split("\\s+");
		String result = "";
		
		for (int i = sArr.length - 1; i > 0; i--)  {
			result += sArr[i];
			result += " ";
		}
		result += sArr[0];
		
		return result;
    }
}
