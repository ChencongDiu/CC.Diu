package String;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int l1 = num1.length();
		int l2 = num2.length();
		int[] nArr = new int[l1 + l2];
		
        for (int i = l1 - 1; i >= 0; i--) {
        	for (int j = l2 - 1; j >= 0; j--) {
        		int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        		int p1 = i + j;     //high
        		int p2 = i + j + 1; //low
        		int sum = mul + nArr[p2];
        		nArr[p1] += sum / 10;
        		nArr[p2] =  sum % 10;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int n: nArr) {
        	if (!(sb.length() ==0 && n == 0))
        		sb.append(n);
        }
		return sb.toString();
    }
}
