package String;

/*
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class ComplexNumberMultiplication {
	public String complexNumberMultiply(String a, String b) {
        String[] aArr = a.split("\\+");
        String[] bArr = b.split("\\+");
        int aR = Integer.parseInt(new String(aArr[0]));
        int bR = Integer.parseInt(new String(bArr[0]));
        int aI = Integer.parseInt(new String(aArr[1].substring(0, aArr[1].length() - 1)));
        int bI = Integer.parseInt(new String(bArr[1].substring(0, bArr[1].length() - 1)));
        int numberR = aR * bR - aI * bI;
        int numberI = aR * bI + aI * bR;
        return String.valueOf(numberR) + "+" + String.valueOf(numberI) + "i";
    }
}
