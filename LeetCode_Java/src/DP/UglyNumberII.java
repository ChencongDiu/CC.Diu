package DP;

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class UglyNumberII {
	//key point: We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, бн) multiply 2, 3, 5.
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 1, index3 = 1, index5 = 1;
        int num2 = 2, num3 = 3, num5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(num2, num3), num5);
            ugly[i] = min;
            //all num == min should be updated! overlapping exist!
            if (min == num2) {
                num2 = 2 * ugly[index2++];
            }
            if (min == num3) {
                num3 = 3 * ugly[index3++];
            }
            if (min == num5) {
                num5 = 5 * ugly[index5++];
            }
        }
        return ugly[n - 1];
    }
}
