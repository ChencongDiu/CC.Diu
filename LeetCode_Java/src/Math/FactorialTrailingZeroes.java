package Math;

/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
		/*int result = 0;
		long fac = 1;
		for (int i = 1; i <= n; i++) {
			fac *= i;
			if (fac % 10 == 0) {
				fac /= 10;
				result++;
			}
				
		}
		return result;*/
		int result = 0;
		while (n != 0) {
			result += n/5;
			n /= 5;
		}
		return result;
    }
}
