package Backtracking;

/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ¡Ü x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ¡Ü x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumberswithUniqueDigits {
	//solve as a math problem
	/*public int countNumbersWithUniqueDigits(int n) {
	    if (n == 0) return 1;
	    if (n >= 10) n = 10;
	    if (n == 1) return 10;
	    int total = 91;
	    int cur = 81;
	    for (int i = 3; i <= n; i++) {
	        cur *= (10 - i + 1);
	        total += cur;
	    }
	    return total;
	}*/
	
	//use backtracking
	public int countNumbersWithUniqueDigits(int n) {
	    if (n >= 10) return countNumbersWithUniqueDigits(10);
	    int total = 0;
	    for (int i = 0; i <= n; i++) {
	        total += backtracking(0, i, new int[10]);
	    }
	    return total;
	}
	
	public int backtracking(int curPos, int maxPos, int[] used) {
	    if (curPos == maxPos) return 1;
	    int total = 0;
	    for (int i = (curPos == 0)? 1: 0; i < 10; i++) {
	        if (used[i] == 0) {
	            used[i] = 1;
	            total += backtracking(curPos + 1, maxPos, used);
	            used[i] = 0;
	        }
	    }
	    return total;
	}
}
