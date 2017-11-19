package Math;

/*
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
 */
public class Base7 {
	public String convertToBase7(int num) {
        if (num == 0) {return "0";}
        String res = "";
        String sign = "";
        if (num < 0) {
            sign = "-";
            num = Math.abs(num);
        }
        while (num != 0) {
            res = Integer.toString(num % 7) + res;
            num = num / 7;
        }
        return sign + res;
    }
}
