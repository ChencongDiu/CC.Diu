package Math;

/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
	public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] sum = new int[Math.max(l1, l2) + 1];
        
        int i = l1 - 1;
        int j = l2 - 1;
        
        while (i >= 0 || j >= 0) {
            int p1 = Math.max(i, j); //high
            int p2 = p1 + 1;         //low
            
            int s = 0;
            
            if (i < 0) {
                s = num2.charAt(j--) - '0';
            } else if (j < 0) {
                s = num1.charAt(i--) - '0';
            } else {
                s = num2.charAt(j--) + num1.charAt(i--) - '0' - '0';
            }
            int tempS = s + sum[p2];
            sum[p1] += tempS / 10;
            sum[p2]  = tempS % 10;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int a: sum) {
            if (!(sb.length() == 0 && a == 0)) sb.append(a);
        }
        
        return (sb.length() == 0)? "0": sb.toString();
    }
}
