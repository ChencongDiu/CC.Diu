package String;

/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
        	int sum = carry;
        	int ai = (i >= 0)? a.charAt(i--) - '0': 0;
        	int bj = (j >= 0)? b.charAt(j--) - '0': 0;
        	sum = sum + ai + bj;
        	sb.append(sum % 2);
        	carry = sum / 2;
        }
        if (carry == 1)	sb.append("1");
        
        return sb.reverse().toString();
    }
}
