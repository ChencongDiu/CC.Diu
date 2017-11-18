package Math;

/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColumnNumber {
	/*public static int titleToNumber(String s) {
	int result = 0;
	char[] sArr = s.toCharArray();
	
	for (int i = sArr.length - 1; i >= 0; i--) {
		int weight = sArr.length - 1 - i;
		result += (sArr[i] - 'A' + 1) * (Math.pow(26, weight));
	}
	
	return result;
}*/
public static int titleToNumber(String s) {
	int result = 0;
	char[] sArr = s.toCharArray();
	
	for (int i = 0; i < sArr.length; i++) {
		result = result * 26 + (sArr[i] - 'A' + 1);
	}
	
	return result;
}
}
