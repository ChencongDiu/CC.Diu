package BitManipulation;

/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
 */
public class SumofTwoIntegers {
	public int getSum(int a, int b) {
        int carry = 0;
        while (b != 0) {
            carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }
}
