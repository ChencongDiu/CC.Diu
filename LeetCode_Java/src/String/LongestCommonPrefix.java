package String;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)	return "";
		String result = strs[0];
		int i = 1;
		while (i < strs.length) {
			while (strs[i].indexOf(result) != 0) {
				result = result.substring(0, result.length() - 1);
			}
			i++;
		}
		
		return result;
    }
}
