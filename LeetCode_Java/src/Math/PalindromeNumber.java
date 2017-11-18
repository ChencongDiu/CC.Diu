package Math;

/*
Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x < 10 && x >= 0)		return true;
		int intP = 0;
		int intO = x;
		while (x > 0) {
			intP = intP*10 + x%10;
			x /= 10;
		}
		return (intO == intP);
    }
}
