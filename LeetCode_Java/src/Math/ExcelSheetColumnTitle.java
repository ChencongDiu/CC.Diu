package Math;

/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		String s = "";
		while (n != 0) {
			n--;
			s = ((char) ('A' + n % 26)) + s;
			n = n / 26;
		}
		return s;
    }
}
