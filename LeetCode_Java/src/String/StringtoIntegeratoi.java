package String;

/*
Implement atoi to convert a string to an integer.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.


 */
public class StringtoIntegeratoi {
	public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int sign = 1, i = 0;
        long res = 0;
        //skip whitespaces
        while (str.charAt(i) == ' ') i++;
        //sign
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        //numbers
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res = res * 10 + (str.charAt(i) - '0');
            } else {
                break;
            }
            if (sign * res >= Integer.MAX_VALUE || sign * res <= Integer.MIN_VALUE) return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        return (int) (sign * res);
    }
}
