package BinarySearch;

/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
	//return (dividend / divisor)
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
        	sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        
        if (ldividend == 0) return 0;
        if (ldivisor == 0) return Integer.MAX_VALUE;
        
        long res = ldivide(ldividend, ldivisor);
        //overflow and underflow
        if (res > Integer.MAX_VALUE) return (sign == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE;
        
        return (int) (sign * res);
    }
    public long ldivide(long ldividend, long ldivisor) {
    	if (ldividend < ldivisor) return 0;
    	long sum = ldivisor;
    	long mult = 1;
    	//binary
    	while (2 * sum <= ldividend) {
    		sum *= 2;
    		mult *= 2;
    	}
		return mult + ldivide(ldividend - sum, ldivisor);
    }
}
