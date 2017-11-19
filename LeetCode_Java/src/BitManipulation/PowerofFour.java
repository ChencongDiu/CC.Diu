package BitManipulation;

/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 */
public class PowerofFour {
	public boolean isPowerOfFour(int num) {
        if (num > 1) {
            while (num % 4 == 0)
                num /= 4;
        }
        return (num == 1);
    }
}
