package BinarySearch;

/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        long n = (long) num;
        while (left <= right) {
            long mid = left - (left - right) / 2;
            if (mid * mid == n) {
                return true;
            } else if (mid * mid < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
